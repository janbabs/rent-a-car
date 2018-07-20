package com.janbabs.service;

import com.janbabs.dto.CustomerDto;
import com.janbabs.model.Address;
import com.janbabs.model.Customer;
import com.janbabs.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerFactory customerFactory;

    public CustomerService(CustomerRepository customerRepository, CustomerFactory customerFactory) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    public Long saveCustomer(CustomerDto customerDto) {
        customerDto.validate();
        Customer customer = customerFactory.create(customerDto);
        customerRepository.save(customer);
        return customer.getId();
    }
    public Long putCustomer(CustomerDto customerDto, Long customerId) {
        final Customer currentCustomer = customerRepository.findOne(customerId);

        if (customerDto == null) {
            throw new IllegalArgumentException("User with id: " + customerId + "doesn't exist!");
        }

        final Address address = currentCustomer.getAddress();
        boolean isAddressChanged = false;

        if(customerDto.getFirstName() != null) {
            currentCustomer.setFirstName(customerDto.getFirstName());
        }
        if(customerDto.getLastName() != null) {
            currentCustomer.setLastName(customerDto.getLastName());
        }
        if(customerDto.getPhoneNumber() != null) {
            currentCustomer.setPhoneNumber(customerDto.getPhoneNumber());
        }

        if(customerDto.getStreetName() != null) {
            address.setStreetName(customerDto.getStreetName());
            isAddressChanged = true;
        }
        if(customerDto.getCity() != null) {
            address.setCity(customerDto.getCity());
            isAddressChanged = true;
        }
        if(customerDto.getHomeNumber() != null) {
            address.setHomeNumber(customerDto.getHomeNumber());
            isAddressChanged = true;
        }
        if(customerDto.getZipCode() != null) {
            address.setZipCode(customerDto.getZipCode());
            isAddressChanged = true;
        }

        if(isAddressChanged) {
            currentCustomer.setAddress(address);
        }

        customerRepository.save(currentCustomer);
        return customerId;
    }
}
