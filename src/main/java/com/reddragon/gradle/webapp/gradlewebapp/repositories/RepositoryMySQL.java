package com.reddragon.gradle.webapp.gradlewebapp.repositories;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Employee;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Entities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RepositoryMySQL implements RepositoryDao {

    private SessionFactory factory;
    private Session session;
    private Entities entities;

    public RepositoryMySQL(Entities entities){

        this.entities = entities;

        factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(this.entities.getClass()).buildSessionFactory();
    }

    @Override
    public boolean saveObiect(Entities e) {

        session = factory.getCurrentSession();

        try {

            System.out.println("Creating Emplouee  .... ");


            session.beginTransaction();

            session.save(e);

            session.getTransaction().commit();

            System.out.println("Done!");

            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            factory.close();
        }

    }

}
