package com.janbabs.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private BigDecimal priceForDay;
    private boolean isRented = false;

    public Car(String manufacturer, String model, int productionYear, BigDecimal priceForDay) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.priceForDay = priceForDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", priceForDay=" + priceForDay +
                ", isRented=" + isRented +
                '}';
    }
}

