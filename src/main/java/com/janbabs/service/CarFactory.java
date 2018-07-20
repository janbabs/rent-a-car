package com.janbabs.service;

import com.janbabs.dto.CarDto;
import com.janbabs.model.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CarFactory {
    public CarFactory() {
    }

    public Car create(CarDto carDto) {
        return new Car(carDto.getManufacturer(), carDto.getModel(),
                Integer.valueOf(carDto.getProductionYear()), new BigDecimal(carDto.getPriceForDay()));
    }
}
