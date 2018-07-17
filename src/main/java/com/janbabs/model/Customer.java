package com.janbabs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    private Address address;
    private String phoneNumber;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Rental> rentals;
}
