package com.reddragon.gradle.webapp.gradlewebapp.controllers;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Employee;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Student;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.FactoryDao;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.RepositoryDao;

public class StartDbApp {

    public static void main(String[] args) {

        Employee employee = new Employee();

        RepositoryDao repositoryDao = FactoryDao.getDatabase("MySQL",employee);

        employee.setFirst_name("Iwona");
        employee.setLast_name("Stolorz");
        employee.setCompany("Przetszkole 1");



        //repositoryDao.saveObiect(employee)
        repositoryDao.deleteObject(2L);

        /*
        System.out.println(repositoryDao.queryAllObject());

        Student student = new Student("Akeksandra", "Stolorz",
                "astolorz@gmail.com");

        RepositoryDao repositoryDao2 = FactoryDao.getDatabase("MySQL",student);

        System.out.println("\n\n\n");

        repositoryDao2.saveObiect(student);


        System.out.println(repositoryDao2.queryAllObject());
        */

    }

}
