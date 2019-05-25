package com.valarchie;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class GroupCar {

    @NotNull
    private String name;


    @Valid
    private GroupDriver driver;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public GroupDriver getDriver() {
        return driver;
    }

    public void setDriver(GroupDriver driver) {
        this.driver = driver;
    }
}
