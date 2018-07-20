package com.janbabs.service;

import com.janbabs.dto.RentalDto;
import com.janbabs.model.Car;
import com.janbabs.model.Customer;
import com.janbabs.model.Rental;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class RentalFactory {
    public RentalFactory() {
    }

    public Rental create(RentalDto rentalDto, Car car, Customer customer) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(rentalDto.getStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(rentalDto.getEndDate(), formatter);
        final long dayDifference = DAYS.between(startDate, endDate);
        final BigDecimal rentalCost = calculateCost(car.getPriceForDay(), dayDifference);
        car.setRented(true);
        return new Rental(startDate, endDate, car, customer, rentalCost);
    }

    public BigDecimal calculateCost(BigDecimal priceForDay, long dayDifference) throws IllegalArgumentException {
        if (dayDifference < 1) {
            throw new IllegalArgumentException("Rental should take at least one day!");
        }
        return priceForDay.multiply(BigDecimal.valueOf(dayDifference));
    }
}
