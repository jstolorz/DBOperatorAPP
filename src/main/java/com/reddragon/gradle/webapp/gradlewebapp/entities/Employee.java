package com.reddragon.gradle.webapp.gradlewebapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id != null)
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if(first_name != null)
          this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        if(last_name != null)
         this.last_name = last_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if(company != null)
         this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
