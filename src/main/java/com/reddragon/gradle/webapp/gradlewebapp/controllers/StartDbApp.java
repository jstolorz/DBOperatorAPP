package com.reddragon.gradle.webapp.gradlewebapp.controllers;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Employee;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.FactoryDao;
import com.reddragon.gradle.webapp.gradlewebapp.repositories.RepositoryDao;

public class StartDbApp {

    public static void main(String[] args) {

        Employee employee = new Employee();

        RepositoryDao repositoryDao = FactoryDao.getDatabase("MySQL",employee);

        employee.setFirst_name("Iwona");
        employee.setLast_name("Stolorz");
        employee.setCompany("Przetszkole 1");

        repositoryDao.saveObiect(employee);

    }

}
