package io.rental;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRentalTest {

    private static final Car CAR1 = new Car("VW", "Golf", "XX11 1UR", "B2", 90);
    private static final Car CAR2 = new Car("VW", "Passat", "XX12 2UR",  "C1", 110);
    private static final Car CAR3 = new Car("VW", "Polo", "XX13 3UR",  "A1", 65);
    private static final Car CAR4 = new Car("VW", "Polo", "XX14 4UR",  "A1", 70);

    private static final Renter RENTER1 = new Renter("Hydrogen", "Joe", "HYDRO010190JX8NM", LocalDate.of(1990, 1, 1));
    private static final Renter RENTER2 = new Renter("Calcium", "Sam", "CALCI010203SX8NM", LocalDate.of(2003, 2, 1));
    private static final Renter RENTER3 = new Renter("Neon", "Maisy", "NEONN010398MX8NM", LocalDate.of(1998, 3, 1));
    private static final Renter RENTER4 = new Renter("Carbon", "Greta", "CARBO010497GX8NM", LocalDate.of(1997, 4, 1));
    
    @Test
    public void testListCarsAvailableToRentGivesMoreThanOneCar() {
        CarRentalCompany carRentalCompany = getCarRentalCompany();

        Criteria criteria = new Criteria();
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isGreaterThan(1);
    }

    private CarRentalCompany getCarRentalCompany() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);
        return carRentalCompany;
    }

    /**
     * Story 1 - finding a car to rent
     * 
     * As a car rental company I want to match a potential renter to a car that I have to rent...
     *   ...So that I can give a list of cars to a potential client.
     *   acceptance criteria: one method returning a list of matching cars
     *   design criteria: the method should be threadsafe (allowing it to be called from multiple threads)
     */
    @Test
    public void testStory1FindCar() {

        CarRentalCompany carRentalCompany = getCarRentalCompany();

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

        CarRentalCompany carRentalCompany = getCarRentalCompany();

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
