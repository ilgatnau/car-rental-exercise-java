package io.rental;

import org.junit.jupiter.api.Test;

import io.utils.DatePeriod;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRentalTest {

    @Test
    public void testListCarsAvailableToRentGivesMoreThanOneCar() {
        CarRentalCompany carRentalCompany = CarRentalTestUtils.getCarRentalCompany();

        Criteria criteria = new Criteria();
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isGreaterThan(1);
    }

}
