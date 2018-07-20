package com.janbabs.service;

import com.janbabs.dto.CustomerDto;
import com.janbabs.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFactoryTest {
    private final String firstName = "John";
    private final String lastName = "Smith";
    private final String phoneNumber = "123 456 789";
    private final String streetName = "Wiejska";
    private final String homeNumber = "4";
    private final String zipCode = "12-345";
    private final String city = "Warsaw";
    private final CustomerDto customerDto = new CustomerDto(firstName, lastName, phoneNumber, streetName, homeNumber, zipCode, city);
    private CustomerFactory customerFactory;

    @Before
    public void setUp() throws Exception {
        customerFactory = new CustomerFactory();
    }

    @Test
    public void shouldCreateCustomer() {
        Customer customer = customerFactory.create(customerDto);
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertEquals(streetName, customer.getAddress().getStreetName());
        assertEquals(homeNumber, customer.getAddress().getHomeNumber());
        assertEquals(zipCode, customer.getAddress().getZipCode());
        assertEquals(city, customer.getAddress().getCity());
    }
}