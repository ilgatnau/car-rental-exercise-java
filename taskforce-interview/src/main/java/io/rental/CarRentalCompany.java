package io.rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.utils.DatePeriod;

public class CarRentalCompany {
    private List<Car> cars = new ArrayList<Car>();
    private List<Renter> renters = new ArrayList<Renter>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public synchronized List<Car> matchingCars(Criteria criteria) {
        List<Car> filteredList = cars.stream()
            .filter(c -> FilterByExactMatches.matchesCriteria(c, criteria)).toList();
        return filteredList;
    }

    public void rentCar(Car car, Renter renter, DatePeriod period) {
        car.rent(renter, period);
    }

    public void returnCar(LocalDate returnDate, Car car) {
        car.returnCar(returnDate);
    }
}
