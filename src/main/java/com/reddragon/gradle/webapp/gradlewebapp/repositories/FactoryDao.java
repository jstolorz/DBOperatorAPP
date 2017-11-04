package com.reddragon.gradle.webapp.gradlewebapp.repositories;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Entities;

public class FactoryDao {

    public static RepositoryDao getDatabase(String db, Entities e){

        switch (db){
            case "MySQL":
                return new RepositoryMySQL(e);
            default:
                return null;
        }
    }

}


