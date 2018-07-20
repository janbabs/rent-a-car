package com.janbabs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String manufacturer;
    private String model;
    private String productionYear;
    private String priceForDay;
    public static final int CURRENT_YEAR = 2018;
    public static final int OLDEST_ACCEPTED_YEAR = 1990;

    public void validate() throws IllegalArgumentException {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Value manufacturer can't be empty!");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Value model can't be empty!");
        }
        if (productionYear == null || productionYear.trim().isEmpty()) {
            throw new IllegalArgumentException("Value productionYear can't be empty!");
        }
        else if (!isCarProductionYearCorrect()) {
            throw new IllegalArgumentException("Value productionYear must be between "
                    + OLDEST_ACCEPTED_YEAR + " and " + CURRENT_YEAR);
        }
        if (priceForDay == null || priceForDay.trim().isEmpty()) {
            throw new IllegalArgumentException("Value priceForDay can't be empty!");
        }
        else if (!isCarPricePositive()) {
            throw new IllegalArgumentException("Value priceForDay can't be negative!");
        }
    }

    public boolean isCarProductionYearCorrect() {
        final int productionYear = Integer.valueOf(getProductionYear());
        return productionYear > OLDEST_ACCEPTED_YEAR && productionYear < CURRENT_YEAR;
    }

    public boolean isCarPricePositive() {
        final BigDecimal priceForDay = new BigDecimal(getPriceForDay());
        return priceForDay.compareTo(BigDecimal.ZERO) > 0;
    }
}
