package com.janbabs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private double mileage;
    private double priceForDay;
    @OneToMany (cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "car")
    @JsonIgnore
    private List<Rental> rentalList;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", priceForDay=" + priceForDay +
                ", rentalList=" + rentalList +
                '}';
    }
}
