package com.janbabs.service;

import com.janbabs.dto.CarDto;
import com.janbabs.model.Car;
import com.janbabs.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    private CarService carService;
    private final String manufacturer = "Ford";
    private final String model = "Mustang";
    private final String productionYear = "2011";
    private final String priceForDay = "69";
    private final CarDto carDto = new CarDto(manufacturer, model, productionYear, priceForDay);

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarFactory carFactory;

    @Mock
    Car car;

    @Before
    public void setUp() throws Exception {
        carService = new CarService(carRepository,carFactory);
    }

    @Test
    public void shouldCreateCar() {
        when(carFactory.create(carDto)).thenReturn(car);
        carService.saveCar(carDto);
        verify(carRepository).save(car);
    }
}