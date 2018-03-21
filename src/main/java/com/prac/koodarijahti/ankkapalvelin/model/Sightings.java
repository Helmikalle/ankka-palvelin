package com.prac.koodarijahti.ankkapalvelin.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Sightings implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    private String species;
    @Lob
    private String description;
    private Date dateTime;
    @Min(value = 1,message = "Count can't be 0.")
    private Integer count;

    protected Sightings() {
    }

    public Sightings(String species, String description, Date dateTime, Integer count) {
        this.species = species;
        this.description = description;
        this.dateTime = dateTime;
        this.count = count;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Sightings{" +
                "id=" + id +
                ", species=" + species +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", count=" + count +
                '}';
    }
}
