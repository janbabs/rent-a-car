package com.janbabs.service;

import com.janbabs.model.Car;
import com.janbabs.model.Rental;
import com.janbabs.repository.CarRepository;
import com.janbabs.repository.CustomerRepository;
import com.janbabs.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jasiek on 22/05/2017.
 */
@AllArgsConstructor
@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final CarService carService;

    public List<Rental> getAllRental() {
        return rentalRepository.findAll();
    }
    public Rental getRentalById(Long id) {
        return rentalRepository.findOne(id);
    }
    public void deleteRentalById(Long id) {
        rentalRepository.delete(id);
    }
    public void deleteAllRentals() {
        rentalRepository.deleteAll();
    }
    public void saveRental(Rental rental, Long customerId, Long carId) {
        Car car = carRepository.findOne(carId);
        if (!car.isEnabled()) {
            System.out.println("Samochod jest niedostepny");
            return;
        }
        car.setEnabled(false);
        carService.putCar(car, carId);
        rental.setCar(car);
        rental.setCustomer(customerRepository.findOne(customerId));
        rentalRepository.save(rental);
    }
    public void putRental(Rental rental, Long id) {
        Rental currentRental = rentalRepository.findOne(id);
        if (currentRental==null) {
            System.out.println("User with id " + id + " not found");
        }
        if(rental.getCreatDate() != null)
            currentRental.setCreatDate(rental.getCreatDate());
        if(rental.getEndDate() != null)
            currentRental.setEndDate(rental.getEndDate());
        rentalRepository.save(currentRental);
    }
}
