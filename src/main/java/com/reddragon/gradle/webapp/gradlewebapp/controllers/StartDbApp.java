package com.reddragon.gradle.webapp.gradlewebapp.controllers;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Employee;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Student;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.FactoryDao;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.RepositoryDao;

import java.lang.reflect.Field;

public class StartDbApp {

    public static void main(String[] args) {

        Employee employee = new Employee();

        RepositoryDao repositoryDao = FactoryDao.getDatabase("MySQL",employee);

        //employee.setId(3l);
        //employee.setFirst_name("Paweł");
        //employee.setLast_name("Stalonn");
        employee.setCompany("UPS");

        System.out.println("===>> [" + employee.getFirst_name() + " ]");

        repositoryDao.updateObject(employee,3L);
        //repositoryDao.deleteObject(2L);


        //System.out.println(repositoryDao.queryAllObject());

        //Student student = new Student("Akeksandra", "Stolorz",
        //"astolorz@gmail.com");

        Student student = new Student();

        RepositoryDao repositoryDao2 = FactoryDao.getDatabase("MySQL",student);

        student.setEmail("dragon@gmail.com");

        System.out.println("\n\n\n");

        repositoryDao2.updateObject(student, 5l);
        //repositoryDao2.saveObiect(student);


        //System.out.println(repositoryDao2.queryAllObject());


    }



}
