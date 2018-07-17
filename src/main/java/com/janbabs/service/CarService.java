package com.janbabs.service;

import com.janbabs.model.Car;
import com.janbabs.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jasiek on 21/05/2017.
 */
@AllArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(Long id) {
        return carRepository.findOne(id);
    }
    public void deleteCarById(Long id) {
        carRepository.delete(id);
    }
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
    public void saveCar(Car car) {;
        if(car.getPriceForDay() < 0.0)
            car.setPriceForDay(100.0);
        if(car.getProductionyear() < 2000)
           car.setProductionyear(2010);
        if(car.getMileage() < 0.0) {
            System.out.println(car.getMileage());
            car.setMileage(0);
        }
        carRepository.save(car);
    }
    public void putCar(Car car, Long id) {
        Car currentCar = carRepository.findOne(id);
        if(car.getPriceForDay() >= 0.0)
            currentCar.setPriceForDay(car.getPriceForDay());
        if(car.getProductionyear() >= 2000)
            currentCar.setProductionyear(car.getProductionyear());
        if(car.getModel() != null)
            currentCar.setModel(car.getModel());
        if(car.getMileage() >= 0.0)
            currentCar.setMileage(car.getMileage());
        if(car.getManufacturer() != null)
            currentCar.setManufacturer(car.getManufacturer());
        if(!car.isEnabled())
            currentCar.setEnabled(car.isEnabled());
        carRepository.save(currentCar);
    }
}
