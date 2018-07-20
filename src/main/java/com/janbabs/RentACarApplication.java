package com.janbabs;

import com.janbabs.dto.CarDto;
import com.janbabs.dto.CustomerDto;
import com.janbabs.dto.RentalDto;
import com.janbabs.model.Address;
import com.janbabs.model.Car;
import com.janbabs.model.Customer;
import com.janbabs.service.CarService;
import com.janbabs.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class RentACarApplication {


    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(CustomerService customerService, CarService carService) {
        return arg -> {
            final CustomerDto customerDto = new CustomerDto("John", "Smith",
                    "123 456 789", "Wiejska", "1", "12-345", "Warsaw");
            final CarDto carDto = new CarDto("Ford", "Mustang", "2011",  "69");
            //Adding customer
            customerService.saveCustomer(customerDto);
            //Adding car
            carService.saveCar(carDto);
        };
    }
}
