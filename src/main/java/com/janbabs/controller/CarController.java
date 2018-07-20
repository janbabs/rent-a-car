package com.janbabs.controller;

import com.janbabs.dto.CarDto;
import com.janbabs.model.Car;
import com.janbabs.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = GET, path = "/all")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(method = GET, path = "/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @RequestMapping(method = POST, path = "/add")
    public Long saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @RequestMapping(method = PUT, path = "/{carId}")
    public Long updateCar(@PathVariable("carId") Long carId, @RequestBody CarDto carDto) {
        return carService.putCar(carDto, carId);
    }
}
