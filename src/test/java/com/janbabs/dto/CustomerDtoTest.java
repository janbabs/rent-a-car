package com.janbabs.dto;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerDtoTest {
    private CustomerDto customerDto = new CustomerDto();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        customerDto.setFirstName("John");
        customerDto.setLastName("Smith");
        customerDto.setPhoneNumber("123 456 789");
        customerDto.setStreetName("Wiejska");
        customerDto.setHomeNumber("1");
        customerDto.setZipCode("12-345");
        customerDto.setCity("Warsaw");
    }

    @Test
    public void shouldThrowExceptionNoFirstName(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value firstName can't be empty!");
        customerDto.setFirstName("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoLastName(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value lastName can't be empty!");
        customerDto.setLastName("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoPhoneNumber(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value phoneNumber can't be empty!");
        customerDto.setPhoneNumber("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionWrongPhoneNumberFormat(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Not supported phone number format!");
        customerDto.setPhoneNumber("123");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoStreetName(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value streetName can't be empty!");
        customerDto.setStreetName("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoHomeNumber(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value homeNumber can't be empty!");
        customerDto.setHomeNumber("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoZipCode(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value zipCode can't be empty!");
        customerDto.setZipCode("");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoSupportedZipCodeFormat(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Not supported zip code format!");
        customerDto.setZipCode("123");
        customerDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoCity(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value city can't be empty!");
        customerDto.setCity("");
        customerDto.validate();
    }
}