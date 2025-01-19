package io.rental;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

/**
 * Story 3 - booking a car

    As a car renter I want to book a car which has been shown to me as being available...
    ...So that I can have a car available to me to use during the rental period
    acceptance criteria: the car rental should be stored in an object model
    acceptance criteria: there should not be able to have overlapping car rentals for the same car
    acceptance criteria: two renters should not be able to book the same car at the same time for an
    overlapping period
    acceptance criteria: one method allowing the car renter to book a car for a period
    design criteria: the in memory storage should consider threadsafety, all access to and from it should
    therefore be threadsafe
 */
public class CarRentalTestStory3 {

        @Test
    public void testStory2FindAvailableCarRentedPeriod() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            null, 
            null, 
            CarRentalTestUtils.CAR3.getRegistrationNumber(), 
            null, 
            0);
        
        DatePeriod datePeriod = 
            new DatePeriod(
                LocalDate.of(2024, 2, 23), 
                LocalDate.of(2024, 2, 27));

        Criteria testStory3 = new Criteria();
        testStory3.setFeatures(carFeatures);
        testStory3.setDatePeriod(datePeriod);


        // 1 car (CAR3) should be available within the period
        assertThat(carRentalCompany.matchingCars(testStory3).size()).isEqualTo(1);

        // Renting car between 25 and 25 Feb
        carRentalCompany.rentCar(
            CarRentalTestUtils.CAR3, 
            CarRentalTestUtils.RENTER1,  
            new DatePeriod(
                LocalDate.of(2024, 2, 25), 
                LocalDate.of(2024, 2, 26))
        );
        

        // No cars should be available after renting within the period of search
        assertThat(carRentalCompany.matchingCars(testStory3).size()).isEqualTo(0);

    }
    
}
