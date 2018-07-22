package com.janbabs.service;

import com.janbabs.dto.CarDto;
import com.janbabs.model.Car;
import com.janbabs.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarFactory carFactory;

    public CarService(CarRepository carRepository, CarFactory carFactory) {
        this.carRepository = carRepository;
        this.carFactory = carFactory;
    }

    @Transactional
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    @Transactional
    public Car getCarById(Long id) {
        return carRepository.findOne(id);
    }
    
    @Transactional
    public Long saveCar(CarDto carDto) {
        carDto.validate();
        Car car = carFactory.create(carDto);
        carRepository.save(car);
        return car.getId();
    }

    @Transactional
    public Long putCar(CarDto carDto, Long id) {
        Car currentCar = carRepository.findOne(id);
        if (carDto.getPriceForDay() != null) {
            if(carDto.isCarPricePositive()) {
                final BigDecimal priceForDay = new BigDecimal(carDto.getPriceForDay());
                currentCar.setPriceForDay(priceForDay);
            }
            else {
                throw new IllegalArgumentException("Value priceForDay can't be negative!");
            }
        }
        if (carDto.getProductionYear() != null) {
            if(carDto.isCarProductionYearCorrect()) {
                final int productionYear = Integer.valueOf(carDto.getProductionYear());
                currentCar.setProductionYear(productionYear);
            }
            else {
                throw new IllegalArgumentException("Value productionYear is incorrect!");
            }
        }
        if(carDto.getModel() != null)
            currentCar.setModel(carDto.getModel());
        if(carDto.getManufacturer() != null)
            currentCar.setManufacturer(carDto.getManufacturer());

        carRepository.save(currentCar);
        return currentCar.getId();
    }
}
