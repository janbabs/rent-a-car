package com.janbabs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate createDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("rentals")
    private Customer customer;
    private BigDecimal rentalCost;

    public Rental(LocalDate createDate, LocalDate endDate, Car car, Customer customer, BigDecimal rentalCost) {
        this.createDate = createDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
        this.rentalCost = rentalCost;
    }
}