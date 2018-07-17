package com.janbabs.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private double mileage;
    private BigDecimal priceForDay;

    public Car(String manufacturer, String model, int productionYear, double mileage, BigDecimal priceForDay) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.priceForDay = priceForDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", priceForDay=" + priceForDay +
                '}';
    }
}
