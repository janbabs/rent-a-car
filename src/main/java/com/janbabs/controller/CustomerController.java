package com.janbabs.controller;

import com.janbabs.dto.CustomerDto;
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
    public Long addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @RequestMapping(method = GET, path = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(method = GET, path = "/all")
    public List<Customer> getCustomerById() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(method = PUT, path = "/{customerId}")
    public Long updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId) {
        return customerService.putCustomer(customerDto, customerId);
    }
}
