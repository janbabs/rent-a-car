package com.janbabs.service;

import com.janbabs.dto.CarDto;
import com.janbabs.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarFactoryTest {
    private CarFactory carFactory;
    private final String productionYear = "2011";
    private final String priceForDay ="69";
    private final String manufacturer = "Ford";
    private final String model = "Mustang";
    private final CarDto carDto = new CarDto(manufacturer, model, productionYear, priceForDay);

    @Before
    public void setUp() throws Exception {
        carFactory = new CarFactory();
    }

    @Test
    public void shouldCreateCar() {
        Car car = carFactory.create(carDto);
        assertEquals(manufacturer, car.getManufacturer());
        assertEquals(model , car.getModel());
        assertEquals(productionYear, String.valueOf(car.getProductionYear()));
        assertEquals(priceForDay, car.getPriceForDay().toString());
    }
}