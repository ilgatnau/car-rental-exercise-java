package io.rental;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Story 1 - finding a car to rent
 * 
 * As a car rental company I want to match a potential renter to a car that I have to rent...
 *   ...So that I can give a list of cars to a potential client.
 *   acceptance criteria: one method returning a list of matching cars
 *   design criteria: the method should be threadsafe (allowing it to be called from multiple threads)
 */
public class CarRentalTestStory1 {

    @Test
    public void testStory1FindCarEmptyCriteria() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            null, 
            null, 
            null, 
            null, 
            0);

        Criteria testStory1 = new Criteria();
        testStory1.setFeatures(carFeatures);

        assertThat(carRentalCompany.matchingCars(testStory1).size()).isGreaterThan(0);
    }

    @Test
    public void testStory1FindCarNonExistingRegistration() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            null, 
            null, 
            "LO25 FFF", 
            null, 
            0);

        Criteria testStory1 = new Criteria();
        testStory1.setFeatures(carFeatures);

        assertThat(carRentalCompany.matchingCars(testStory1).size()).isEqualTo(0);
    }

    @Test
    public void testStory1FindCarByRegistration() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            null, 
            null, 
            "XX11 1UR", 
            null, 
            0);

        Criteria testStory1 = new Criteria();
        testStory1.setFeatures(carFeatures);

        assertThat(carRentalCompany.matchingCars(testStory1).size()).isEqualTo(1);
    }

    @Test
    public void testStory1FindCarByMakeAndModel() {

        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Car carFeatures = new Car(
            "VW", 
            "Golf", 
            "XX11 1UR", 
            null, 
            0);

        Criteria testStory1 = new Criteria();
        testStory1.setFeatures(carFeatures);

        assertThat(carRentalCompany.matchingCars(testStory1).size()).isEqualTo(1);
    }

}
