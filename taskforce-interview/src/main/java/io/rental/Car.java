package io.rental;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import io.utils.DatePeriod;
import io.utils.DatePeriodUtil;
import lombok.Getter;


public class Car {
    @Getter private final String make;
    @Getter private final String model;
    @Getter private final String registrationNumber;
    @Getter private final String rentalGroup;
    @Getter private final double costPerDay;

    @Getter private List<RentedPeriod> rentedBy = new ArrayList<RentedPeriod>();

    public Car(String make, String model, String registrationNumber, String rentalGroup, double costPerDay) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.rentalGroup = rentalGroup;
        this.costPerDay = costPerDay;
    }

    public void rent(Renter renter, DatePeriod period){

        // Double check it is not rented already
        assert(findCurrentPeriod(period.getStart()) == null);
        assert(findCurrentPeriod(period.getEnd()) == null);

        rentedBy.add(new RentedPeriod(renter, period));
    }

    public void returnCar(LocalDate returnDate){
        RentedPeriod rentedPeriod = findCurrentPeriod(returnDate);
        rentedPeriod.setDateReturned(returnDate);
    }

    public RentedPeriod findCurrentPeriod(LocalDate returnDate) {

        try {
        return rentedBy.stream().filter(
            r -> DatePeriodUtil.isInPeriod(returnDate, r.getPeriod()))
            .findFirst()
            .get();
        } catch (NoSuchElementException ex) {
            return null;
        }

    }

    public boolean findOverlappingPeriod(DatePeriod overlapping) {

        try {
        return rentedBy.stream().filter(
            r -> DatePeriodUtil.areOverlapping(overlapping, r.getPeriod()))
            .count() > 0;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

}
