package com.reddragon.gradle.webapp.gradlewebapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String marka;
    private String vin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id != null)
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model != null)
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        if(marka != null)
        this.marka = marka;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        if(vin != null)
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", marka='" + marka + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id != null ? id.equals(car.id) : car.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
