package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.CustomerDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.exception.ValidateException;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.repository.CustomerRepository;
import com.bumblebee.project.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void createCustomer(CustomerDTO customerDTO) throws MessagingException {
        System.out.println(customerRepository.existsByEmail(customerDTO.getEmail()));
        if (customerRepository.existsByEmail(customerDTO.getEmail()) == 1){
            throw new ValidateException("Customer Already Registered");
        }
        customerDTO.setActivationCode(UUID.randomUUID().toString());
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
        sendActivationEmail(customerDTO);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new AdminNotFoundException("Customer not found with id: " + customerId));
    }

    @Override
    public Customer updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Customer customer = getCustomerById(customerId);
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setPassword(customerDTO.getPassword());
        customer.setAddressLine1(customerDTO.getAddressLine1());
        customer.setCity(customerDTO.getCity());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setStatus(customerDTO.getStatus());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = getCustomerById(customerId);
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void activate(String activationCode) {
        Customer customer = customerRepository.findByActivationCode(activationCode);
        if (customer != null) {
            customer.setEnabled(true);
            customer.setActivationCode(null);
            customerRepository.save(customer);
        }
    }

    @Override
    public void sendActivationEmail(CustomerDTO customerDTO) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(customerDTO.getEmail());
        helper.setSubject("Welcome to MyStore - Activate Your Account Now!");

        String htmlContent = "<html><body>" +
                "<p>Dear " + customerDTO.getFirstName() +" "+ customerDTO.getLastName() + ",</p>" +
                "<p>Thank you for registering on MyStore! We're excited to have you as a customer.</p>" +
                "<p>To get started, you'll need to activate your account. Please click the button below to activate your account and start shopping!</p>" +
                "<a href='http://localhost:8080/api/customer/activate/" + customerDTO.getActivationCode() + "' style='padding: 10px 20px; background-color: #0066cc; color: #fff; text-decoration: none; border-radius: 5px;'>Activate My Account</a>" +
                "<p>If the button above doesn't work, please copy and paste the following link into your browser:</p>" +
                "<p>http://localhost:8080/api/customer/activate/" + customerDTO.getActivationCode() + "</p>" +
                "<p>If you have any questions or need assistance, please don't hesitate to contact us at <a href='mailto:support@mystore.com'>support@mystore.com</a>.</p>" +
                "<p>Thank you for choosing MyStore!</p>" +
                "<p>Best regards,</p>" +
                "<p>The MyStore Team</p>" +
                "</body></html>";
        helper.setText(htmlContent, true);
        mailSender.send(message);
    }

    @Override
    public Long getCustomerCount() {
        return customerRepository.count();
    }
}
