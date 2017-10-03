package com.janbabs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String company;
    private String model;
    private int productionyear;
    private double mileage;
    private double price;
    private boolean enabled = true;
    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "car")
    @JsonIgnore
    private List<Rental> rentalList;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionyear() {
        return productionyear;
    }

    public void setProductionyear(int productionyear) {
        this.productionyear = productionyear;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", productionyear=" + productionyear +
                ", mileage=" + mileage +
                ", price=" + price +
                ", enabled=" + enabled +
                ", rentalList=" + rentalList +
                '}';
    }
}
