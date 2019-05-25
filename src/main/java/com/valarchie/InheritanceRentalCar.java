package com.valarchie;

import com.valarchie.InheritanceCar;

import javax.validation.constraints.NotNull;

public class InheritanceRentalCar extends InheritanceCar {


    private String rentalStation;

    @NotNull
    public String getRentalStation() {
        return rentalStation;
    }


    public void setRentalStation(String rentalStation) {
        this.rentalStation = rentalStation;
    }


}
