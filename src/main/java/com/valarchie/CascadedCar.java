package com.valarchie;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 串联多级校验
 */
public class CascadedCar {

    private List<@NotNull @Valid Person> passengers = new ArrayList<Person>();


    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }

}
