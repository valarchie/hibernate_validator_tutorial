package com.valarchie;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GraphsCar {


    @NotNull
    @Valid
    private Person driver;

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }


}
