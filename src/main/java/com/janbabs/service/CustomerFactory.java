package com.janbabs.service;

import com.janbabs.dto.CustomerDto;
import com.janbabs.model.Address;
import com.janbabs.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {
    public CustomerFactory() {
    }

    public Customer create(CustomerDto customerDto) {
        Address address = new Address(customerDto.getStreetName(),
                customerDto.getHomeNumber(), customerDto.getZipCode(), customerDto.getCity());
        return new Customer(customerDto.getFirstName(), customerDto.getLastName(),
                address, customerDto.getPhoneNumber());
    }
}
