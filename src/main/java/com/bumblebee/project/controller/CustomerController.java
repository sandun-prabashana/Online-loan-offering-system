package com.bumblebee.project.controller;


import com.bumblebee.project.dto.CustomerDTO;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.service.CustomerService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws MessagingException {
        System.out.println("ok");
        customerService.createCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("200", "Customer Register successfully", customerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getAdminById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity(new StandardResponse("200", "Customer retrieved successfully", customer), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateAdmin(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity(new StandardResponse("200", "Customer updated successfully", customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Customer deleted successfully", id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllAdmins() {
        List<Customer> customer = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse("200", "Customer retrieved successfully", customer), HttpStatus.OK);
    }


    @GetMapping(value = "/activate/{activationCode}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> activate(@PathVariable String activationCode) {
        customerService.activate(activationCode);
        String successMessage = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; text-align: center; }" +
                "h1 { color: #4CAF50; }" +
                "p { font-size: 18px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>Activation Successful!</h1>" +
                "<p>Your account has been activated. You can now login and start using our services.</p>" +
                "</body>" +
                "</html>";

        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }


    @GetMapping("/count")
    public ResponseEntity<Long> getCustomerCount() {
        Number count = customerService.getCustomerCount();
        System.out.println(count);
        return new ResponseEntity(new StandardResponse("200", "Customer Count", count), HttpStatus.OK);
    }

    @GetMapping("ACTIVE/countByStatus")
    public Integer getCustomerCountACT() {
        return customerService.getCustomerCountByACT();
    }

    @GetMapping("DEACTIVE/countByStatus")
    public Integer getCustomerCountDEACT() {
        return customerService.getCustomerCountByDEACT();
    }

}

