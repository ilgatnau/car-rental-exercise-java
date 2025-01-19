package io.rental;

import java.util.Comparator;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import io.utils.DatePeriod;

public class FilterByExactMatches {

    public static boolean matchesCriteria (Car car, Criteria criteria) {

        Car carFeaturesCriteria = criteria.getFeatures();

        if(carFeaturesCriteria.getMake() != null 
            && car.getMake().indexOf(carFeaturesCriteria.getMake()) < 0){
            return false;
        }

        if (carFeaturesCriteria.getModel() != null 
            && car.getModel().indexOf(carFeaturesCriteria.getModel()) < 0){
            return false;
        }

        if (carFeaturesCriteria.getRegistrationNumber() != null &&
            !StringUtils.equals(car.getRegistrationNumber(), carFeaturesCriteria.getRegistrationNumber())) {
            return false;
        }

        if (carFeaturesCriteria.getRentalGroup() != null &&
            !StringUtils.equals(car.getRentalGroup(), carFeaturesCriteria.getRentalGroup())) {
            return false;
        }

        return true;
    }


    
}
