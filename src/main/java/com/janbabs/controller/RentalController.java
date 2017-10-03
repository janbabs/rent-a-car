package com.janbabs.controller;

import com.janbabs.model.Rental;
import com.janbabs.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("/rentals")
        public List<Rental> getAllRental(){
        return rentalService.getAllRental();
    }

    @GetMapping("/rental/{id}")
    public Rental getRental(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PostMapping("/customer/{customerId}/rental/{carId}")
    public  void  saveRental(@RequestBody Rental rental, @PathVariable Long customerId, @PathVariable Long carId) {

        rentalService.saveRental(rental, customerId, carId);
    }

    @DeleteMapping("/rental/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRentalById(id);
    }

    @PutMapping("/rental/{id}")
    public void putRental(@RequestBody Rental rental,@PathVariable Long id) {
        rentalService.putRental(rental, id);
    }
}