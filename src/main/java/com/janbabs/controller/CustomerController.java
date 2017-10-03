package com.janbabs.controller;

import com.janbabs.model.Customer;
import com.janbabs.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer>  getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public  Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/customer/{id}")
    public void putCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        customerService.putCustomer(customer, id);
    }
}
