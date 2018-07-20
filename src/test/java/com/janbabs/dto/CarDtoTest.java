package com.janbabs.dto;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.janbabs.dto.CarDto.CURRENT_YEAR;
import static com.janbabs.dto.CarDto.OLDEST_ACCEPTED_YEAR;

public class CarDtoTest {

    private CarDto carDto = new CarDto();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        carDto.setManufacturer("Ford");
        carDto.setModel("Mustang");
        carDto.setProductionYear("2011");
        carDto.setPriceForDay("69");
    }

    @Test
    public void shouldThrowExceptionNoManufacturer(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value manufacturer can't be empty!");
        carDto.setManufacturer("");
        carDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoModel(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value model can't be empty!");
        carDto.setModel("");
        carDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoProductionYear(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value productionYear can't be empty!");
        carDto.setProductionYear("");
        carDto.validate();
    }

    @Test
    public void shouldThrowExceptionNegativeProductionYear(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value productionYear must be between "
                + OLDEST_ACCEPTED_YEAR + " and " + CURRENT_YEAR);
        carDto.setProductionYear("-2000");
        carDto.validate();
    }

    @Test
    public void shouldThrowExceptionNoPriceForDayYear(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value priceForDay can't be empty!");
        carDto.setPriceForDay("");
        carDto.validate();
    }

    @Test
    public void shouldThrowExceptionNegativePrice(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value priceForDay can't be negative!");
        carDto.setPriceForDay("-20");
        carDto.validate();
    }
}