package com.janbabs.service;

import com.janbabs.dto.RentalDto;
import com.janbabs.model.Car;
import com.janbabs.model.Customer;
import com.janbabs.model.Rental;
import com.janbabs.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final RentalFactory rentalFactory;

    public RentalService(RentalRepository rentalRepository, CarService carService
            , CustomerService customerService, RentalFactory rentalFactory) {
        this.rentalRepository = rentalRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.rentalFactory = rentalFactory;
    }

    public List<Rental> getAllRental() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findOne(id);
    }

    public Long makeRental(RentalDto rentalDto) {
        rentalDto.validate();
        Car car = carService.getCarById(rentalDto.getCarId());
        Customer customer = customerService.getCustomerById(rentalDto.getCustomerId());
        if (customer == null) {
            throw new IllegalArgumentException("Customer with id " +
                    rentalDto.getCustomerId() + " does not exist!");
        }
        if (car == null) {
            throw new IllegalArgumentException("Car with id " +
                    rentalDto.getCarId() + " does not exist!");
        }
        if (checkIfRented(car)) {
            throw new IllegalArgumentException("Car with id " +
                    rentalDto.getCarId() + " is already rented!");
        }

        Rental rental = rentalFactory.create(rentalDto, car, customer);
        rentalRepository.save(rental);
        return rental.getId();
    }

    private boolean checkIfRented(Car car) {
        return car.isRented();
    }

    public List<Rental> getAllByCustomerId(Long customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }
}
