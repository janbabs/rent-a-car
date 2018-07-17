package com.janbabs.controller;

import com.janbabs.model.Customer;
import com.janbabs.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = POST, path = "/add")
    public Long addCustomer(@RequestBody Customer customerToSave) {
        return this.customerService.saveCustomer(customerToSave);
    }

    @RequestMapping(method = GET, path = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
        return this.customerService.getCustomerById(customerId);
    }
    @RequestMapping(method = GET, path = "/all")
    public List<Customer> getCustomerById() {
        return this.customerService.getAllCustomers();
    }
}
