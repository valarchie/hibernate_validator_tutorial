package com.valarchie;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class CarWithMap {


    public enum FuelConsumption {
        CITY,
        HIGHWAY
    }

    private Map<@NotNull FuelConsumption, @Max(value = 2) Integer> fuelConsumption = new HashMap<>();

    public void setFuelConsumption(FuelConsumption consumption, int value) {
        fuelConsumption.put( consumption, value );
    }




}
