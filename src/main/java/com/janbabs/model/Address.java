package com.janbabs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String homeNumber;
    private String zipCode;
    private String city;

    public Address(String streetName, String homeNumber, String zipCode, String city) {
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
