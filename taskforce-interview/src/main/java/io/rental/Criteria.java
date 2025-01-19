package io.rental;

import java.util.Comparator;

import io.utils.DatePeriod;
import lombok.Getter;
import lombok.Setter;

public class Criteria {
   
 @Getter @Setter DatePeriod datePeriod;
 @Getter @Setter Car features;

}
