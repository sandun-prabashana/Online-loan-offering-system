package com.bumblebee.project.service;


import com.bumblebee.project.dto.CustomerDTO;
import com.bumblebee.project.model.Customer;

import javax.mail.MessagingException;
import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDTO customerDTO) throws MessagingException;
    Customer getCustomerById(Long customerId);
    Customer updateCustomer(Long customerId, CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<Customer> getAllCustomer();
    void activate(String activationCode);
    void sendActivationEmail(CustomerDTO customerDTO) throws MessagingException;

    Long getCustomerCount();

    Integer getCustomerCountByACT();
    Integer getCustomerCountByDEACT();

}
