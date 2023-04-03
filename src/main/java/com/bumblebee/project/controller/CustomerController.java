package com.bumblebee.project.controller;


import com.bumblebee.project.dto.CustomerDTO;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.service.CustomerService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createAdmin(@RequestBody CustomerDTO customerDTO) throws MessagingException {
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

    @GetMapping("/activate/{activationCode}")
    public String activate(@PathVariable String activationCode) {
        customerService.activate(activationCode);
        return "activation_successful";
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCustomerCount() {
        Number count = customerService.getCustomerCount();
        System.out.println(count);
        return new ResponseEntity(new StandardResponse("200", "Customer Count", count), HttpStatus.OK);
    }

}

