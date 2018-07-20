package com.janbabs.service;

import com.janbabs.dto.RentalDto;
import com.janbabs.model.Car;
import com.janbabs.model.Customer;
import com.janbabs.model.Rental;
import com.janbabs.repository.RentalRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentalServiceTest {

    private RentalService rentalService;

    private Long carId = 1L;
    private Long customerId = 1L;
    private String startDate = "2018-07-20";
    private String endDate = "2018-07-22";
    private final String manufacturer = "Ford";
    private final String model = "Mustang";
    private final int productionYear = 2011;
    private final BigDecimal priceForDay = new BigDecimal(69);
    private RentalDto rentalDto;
    private Car car;

    @Mock
    private RentalRepository rentalRepository;

    @Mock
    private RentalFactory rentalFactory;

    @Mock
    private CarService carService;

    @Mock
    private CustomerService customerService;

    @Mock
    private Customer customer;

    @Mock
    private Rental rental;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        rentalService = new RentalService(rentalRepository, carService, customerService, rentalFactory);
        rentalDto = new RentalDto(customerId, carId, startDate, endDate);
        car =  new Car(manufacturer, model, productionYear, priceForDay);
    }

    @Test
    public void shouldCreateRental() {
        when(carService.getCarById(rentalDto.getCarId())).thenReturn(car);
        when(customerService.getCustomerById(rentalDto.getCustomerId())).thenReturn(customer);
        when(rentalFactory.create(rentalDto, car, customer)).thenReturn(rental);
        rentalService.makeRental(rentalDto);
        verify(rentalRepository).save(rental);
    }

    @Test
    public void shouldThrowExceptionWhenCarIsNotAvailable(){
        when(customerService.getCustomerById(rentalDto.getCustomerId())).thenReturn(customer);
        when(carService.getCarById(rentalDto.getCarId())).thenReturn(car);
        exception.expect(IllegalArgumentException.class);
        car.setRented(true);
        exception.expectMessage("Car with id 1 is already rented!");

        rentalService.makeRental(rentalDto);
    }
}