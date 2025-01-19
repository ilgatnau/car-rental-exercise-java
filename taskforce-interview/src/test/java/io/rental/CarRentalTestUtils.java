package io.rental;

import java.time.LocalDate;

public class CarRentalTestUtils {

    public static final Car CAR1 = new Car("VW", "Golf", "XX11 1UR", "B2", 90);
    public static final Car CAR2 = new Car("VW", "Passat", "XX12 2UR",  "C1", 110);
    public static final Car CAR3 = new Car("VW", "Polo", "XX13 3UR",  "A1", 65);
    public static final Car CAR4 = new Car("VW", "Polo", "XX14 4UR",  "A1", 70);

    public static final Renter RENTER1 = new Renter("Hydrogen", "Joe", "HYDRO010190JX8NM", LocalDate.of(1990, 1, 1));
    public static final Renter RENTER2 = new Renter("Calcium", "Sam", "CALCI010203SX8NM", LocalDate.of(2003, 2, 1));
    public static final Renter RENTER3 = new Renter("Neon", "Maisy", "NEONN010398MX8NM", LocalDate.of(1998, 3, 1));
    public static final Renter RENTER4 = new Renter("Carbon", "Greta", "CARBO010497GX8NM", LocalDate.of(1997, 4, 1));
    

    public static CarRentalCompany getCarRentalCompany() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);
        return carRentalCompany;
    }

}
