package com.janbabs.service;

import com.janbabs.dto.CustomerDto;
import com.janbabs.model.Customer;
import com.janbabs.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    private CustomerService customerService;
    private final String firstName = "John";
    private final String lastName = "Smith";
    private final String phoneNumber = "123 456 789";
    private final String streetName = "Wiejska";
    private final String homeNumber = "1";
    private final String zipCode = "12-345";
    private final String city = "Warsaw";
    private final CustomerDto customerDto = new CustomerDto(firstName
            , lastName, phoneNumber, streetName, homeNumber, zipCode, city);

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerFactory customerFactory;

    @Mock
    private Customer customer;

    @Before
    public void setUp() {
        customerService = new CustomerService(customerRepository, customerFactory);
    }

    @Test
    public void shouldAddCustomer() {
        when(customerFactory.create(customerDto)).thenReturn(customer);
        customerService.saveCustomer(customerDto);
        verify(customerRepository).save(customer);
    }
}