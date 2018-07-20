package com.janbabs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RentalDto {
    private Long customerId;
    private Long carId;
    private String startDate;
    private String endDate;

    public void validate() {
        if(customerId == null || customerId < 0)
            throw new IllegalArgumentException("Incorrect customer id");
        if(carId == null || carId < 0)
            throw new IllegalArgumentException("Incorrect car id");
        if (startDate == null || startDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Value startDate can't be empty!");
        }
        else if(!startDate.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
            throw new IllegalArgumentException("Incorrect start date");
        }
        if (endDate == null || endDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Value endDate can't be empty!");
        }
        else if(!endDate.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
            throw new IllegalArgumentException("Incorrect end date");
        }
    }
}
