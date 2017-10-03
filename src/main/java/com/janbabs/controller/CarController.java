package com.janbabs.controller;

import com.janbabs.model.Car;
import com.janbabs.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CarController {
    private final CarService carService;

    @GetMapping("/car")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/car")
    public  void  saveCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @PutMapping("/car/{id}")
    public void putCar(@PathVariable Long id,@RequestBody Car car) {
        carService.putCar(car, id);
    }
}
