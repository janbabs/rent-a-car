package com.janbabs.service;

import com.janbabs.model.Customer;
import com.janbabs.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jasiek on 21/05/2017.
 */
@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }
    public void deleteCustomerById(Long id) {
        customerRepository.delete(id);
    }
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void putCustomer(Customer customer, Long id) {
        Customer currentCustomer = customerRepository.findOne(id);
        if(customer.getAddress()!= null)
            currentCustomer.setAddress(customer.getAddress());
        if(customer.getFirst_name() != null)
            currentCustomer.setFirst_name(customer.getFirst_name());
        if(customer.getLast_name() != null)
            currentCustomer.setLast_name(customer.getLast_name());
        if(customer.getPhoneNumber() != null)
            currentCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(currentCustomer);
    }
}
