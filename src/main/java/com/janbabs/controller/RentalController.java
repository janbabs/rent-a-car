package com.janbabs.controller;

import com.janbabs.dto.RentalDto;
import com.janbabs.model.Rental;
import com.janbabs.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @RequestMapping(method = GET, path = "/all")
    public List<Rental> getAllRental(){
        return rentalService.getAllRental();
    }

    @RequestMapping(method = GET, path = "/{id}")
    public Rental getRental(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @RequestMapping(method = POST, path = "/add")
    public Long makeRental(@RequestBody RentalDto rentalDto) {
        return rentalService.makeRental(rentalDto);
    }

    @RequestMapping(method = GET, path = "/customer/{customerId}")
    public List<Rental> getAllRentalsByCustomerId(@PathVariable("customerId") Long customerId) {
        return rentalService.getAllByCustomerId(customerId);
    }
}