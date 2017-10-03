package com.janbabs.repository;

import com.janbabs.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long>{
    public List<Rental> findByCustomerId(Long customerId);
}
