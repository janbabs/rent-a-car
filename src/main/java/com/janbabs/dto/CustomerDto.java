package com.janbabs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetName;
    private String homeNumber;
    private String zipCode;
    private String city;

    public void validate() throws IllegalArgumentException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Value firstName can't be empty!");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Value lastName can't be empty!");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Value phoneNumber can't be empty!");
        } else if(!phoneNumber.matches("(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)")) {
            throw new IllegalArgumentException("Not supported phone number format!");
        }
        if (streetName == null || streetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Value streetName can't be empty!");
        }
        if (homeNumber== null || homeNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Value homeNumber can't be empty!");
        }
        if (zipCode == null || zipCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Value zipCode can't be empty!");
        } else if (!zipCode.matches("[0-9]{2}-[0-9]{3}")) {
            throw new IllegalArgumentException("Not supported zip code format!");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Value city can't be empty!");
        }

    }
}
