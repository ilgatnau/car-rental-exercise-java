package io.rental;

import java.util.Comparator;

import io.utils.DatePeriod;

public class FilterByExactMatches {

    public static synchronized boolean matchesCriteria (Car car, Criteria criteria) {

        return false;
    }

    private class CarMakeComparator implements Comparator<Car> {

        @Override
        public int compare(Car arg0, Car arg1) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'compare'");
        }
        
    }

    private class DatePeriodComparator implements Comparator<DatePeriod> {

        @Override
        public int compare(DatePeriod arg0, DatePeriod arg1) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'compare'");
        }
        
    }
    
}
