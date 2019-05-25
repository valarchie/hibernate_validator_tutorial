package com.valarchie;

import javax.validation.constraints.NotNull;

public class InheritanceCar {

    private String manufacturer;

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
