package com.reddragon.gradle.webapp.gradlewebapp.repositories;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Entities;

import java.util.List;

public interface RepositoryDao {

    boolean saveObiect(Entities e);
    List<Entities> queryAllObject();
}
