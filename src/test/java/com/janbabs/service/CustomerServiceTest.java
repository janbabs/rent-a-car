package com.janbabs.service;

import com.janbabs.model.Address;
import com.janbabs.model.Customer;
import com.janbabs.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerServiceTest {
    private CustomerService customerService;
    private final String streetName = "Konstantynow";
    private final String homeNumber = "4";
    private final String zipCode = "20-882";
    private final String city = "Warszawa";
    private final Address address = new Address(streetName, homeNumber, zipCode, city);
    private final String firstName = "Jan";
    private final String lastName = "Kowalski";
    private final String phoneNumber = "123456789";
    private final String updated_FirstName = "Anna";
    private final String updated_LastName = "Nowak";



    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void addCustomer() {
        final Customer customer = new Customer(firstName, lastName, address, phoneNumber);
        final Long idOfSavedCustomer = customerService.saveCustomer(customer);
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                "/api/customer/{idOfSavedCustomer}", String.class, idOfSavedCustomer);

        assertThat(response.getBody(), containsString(firstName));
        assertThat(response.getBody(), containsString(lastName));
        assertThat(response.getBody(), containsString(phoneNumber));
        assertThat(response.getBody(), containsString(streetName));
        assertThat(response.getBody(), containsString(homeNumber));
        assertThat(response.getBody(), containsString(zipCode));
        assertThat(response.getBody(), containsString(city));
    }

    @Test
    public void updateCustomer() {
        final Customer customer = new Customer(firstName, lastName, address, phoneNumber);
        final Long customerId = customerService.saveCustomer(customer);
        final Customer updateCustomer = new Customer();

        updateCustomer.setFirst_name(updated_FirstName);
        updateCustomer.setLast_name(updated_LastName);

        customerService.putCustomer(updateCustomer, customerId);

        ResponseEntity<String> response = this.restTemplate.getForEntity(
                "/api/customer/{customerId}", String.class, customerId);

        assertThat(response.getBody(), containsString(updated_FirstName));
        assertThat(response.getBody(), containsString(updated_LastName));
        assertThat(response.getBody(), containsString(phoneNumber));
        assertThat(response.getBody(), containsString(streetName));
        assertThat(response.getBody(), containsString(homeNumber));
        assertThat(response.getBody(), containsString(zipCode));
        assertThat(response.getBody(), containsString(city));
    }

}