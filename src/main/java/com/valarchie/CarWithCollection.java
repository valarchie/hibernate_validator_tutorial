package com.valarchie;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class CarWithCollection {


    private Set<@NotNull String> parts;

    private List<@NotBlank String> names;


    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Set<String> getParts() {
        return parts;
    }

    public void setParts(Set<String> parts) {
        this.parts = parts;
    }
}
