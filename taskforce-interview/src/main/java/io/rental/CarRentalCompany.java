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

    /**
     * Thread safe method (as per specifications), 
     * even though a list of cars available in a matching criteria may not be valid when trying
     * to rent the car, so not sure how useful this is or whether this may impact user experience
     * @param criteria
     * @return
     */
    public synchronized List<Car> matchingCars(Criteria criteria) {
        List<Car> filteredList = cars.stream()
            .filter(c -> FilterByExactMatches.matchesCriteria(c, criteria)).toList();
        return filteredList;
    }

    /**
     * Thread safe method in case multiple clients want to rent a car in same period
     * @param car
     * @param renter
     * @param period
     */
    public synchronized void rentCar(Car car, Renter renter, DatePeriod period) {
        car.rent(renter, period);
    }

    
    public void returnCar(LocalDate returnDate, Car car) {
        car.returnCar(returnDate);
    }
}
