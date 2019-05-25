package com.valarchie;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class CarWithGetter {


    private String manufacturer;

    private boolean isRegistered;

    public CarWithGetter(String manufacturer, boolean isRegistered) {
        this.manufacturer = manufacturer;
        this.isRegistered = isRegistered;
    }

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @AssertTrue
    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }



}
