package io.rental;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

/**
 * Story 4 - car preparation

As a car rental company I need to understand what cars are coming up as new rentals on a specific date...
...So that I can make sure they are clean and ready to be rented
acceptance criteria: one method return all new rentals for the coming week ordered by date
acceptance criteria: the structure of the date returned should include the car model/make and it&#39;s
registration as well as the date rented
 */
public class CarRentalTestStory4 {

    @Test
    public void testStory4FindCarsRentedNextWeek() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        carRentalCompany.rentCar(
            CarRentalTestUtils.CAR3, 
            CarRentalTestUtils.RENTER2,  
            new DatePeriod(
                LocalDate.of(2024, 2, 26), 
                LocalDate.of(2024, 2, 28))
        );

        carRentalCompany.rentCar(
            CarRentalTestUtils.CAR1, 
            CarRentalTestUtils.RENTER1,  
            new DatePeriod(
                LocalDate.of(2024, 2, 25), 
                LocalDate.of(2024, 2, 26))
        );

        carRentalCompany.rentCar(
            CarRentalTestUtils.CAR1, 
            CarRentalTestUtils.RENTER3,  
            new DatePeriod(
                LocalDate.of(2024, 3, 01), 
                LocalDate.of(2024, 3, 04))
        );

    
        DatePeriod nextWeekPeriod =
            new DatePeriod(
                LocalDate.of(2024, 2, 21), 
                LocalDate.of(2024, 2, 27));

        Criteria testStory4 = new Criteria();
        testStory4.setDatePeriod(nextWeekPeriod);

        assertThat(carRentalCompany.matchingCars(testStory4).size()).isEqualTo(2);

    }
}
