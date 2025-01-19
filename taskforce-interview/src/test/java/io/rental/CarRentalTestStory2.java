package io.rental;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRentalTestStory2 {


    /**
     * Story 2 - finding an available car to be rented
     *   As a car renter I want to know if a car is available to be rented on the dates I need...
     *   ...So that i can provide a list of cars that are available on the dates given by the renter
     *   acceptance criteria: the matching criteria for a renter to rent a car should include a from date and to date
     *   acceptance criteria: the car renter should not be shown any cars that are booked in the period that is
     *   supplied
     *   acceptance criteria: one method returning a list of matching cars (with the filter having changed)
     *   design criteria: the method should be threadsafe (allowing it to be called from multiple threads)
     */
    @Test
    public void testStory2FindAvailableCar() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            null, 
            null, 
            null, 
            null, 
            0);
        
        DatePeriod datePeriod = 
            new DatePeriod(
                LocalDate.of(2024, 2, 23), 
                LocalDate.of(2024, 2, 27));

        Criteria testStory2 = new Criteria();
        testStory2.setFeatures(carFeatures);
        testStory2.setDatePeriod(datePeriod);

        assertThat(carRentalCompany.matchingCars(testStory2).size()).isGreaterThan(0);

    }
}
