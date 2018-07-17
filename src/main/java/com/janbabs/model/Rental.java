package com.janbabs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

}