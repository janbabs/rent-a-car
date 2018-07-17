package com.janbabs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phoneNumber;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String first_name, String last_name, Address address, String phoneNumber) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
