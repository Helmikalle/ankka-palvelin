package com.prac.koodarijahti.ankkapalvelin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Species implements Serializable {
    @Id private String name;

    public Species(String name) {
        this.name = name;
    }

    public Species() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                '}';
    }
}
