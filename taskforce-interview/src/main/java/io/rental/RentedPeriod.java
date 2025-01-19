package io.rental;

import java.time.LocalDate;

import io.utils.DatePeriod;
import lombok.Getter;
import lombok.Setter;

public class RentedPeriod {

    @Getter DatePeriod period;
    @Getter Renter renter;
    @Getter @Setter LocalDate dateReturned;

    public RentedPeriod(Renter renter, DatePeriod period) {
        this.renter = renter;
        this.period = period;
    }
    
}
