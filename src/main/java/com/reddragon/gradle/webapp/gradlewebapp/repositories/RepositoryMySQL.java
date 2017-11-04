package com.reddragon.gradle.webapp.gradlewebapp.repositories;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Employee;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Entities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RepositoryMySQL implements RepositoryDao {

    private SessionFactory factory;
    private Session session;
    private Entities entities;

    public RepositoryMySQL(Entities entities) {

        this.entities = entities;

    }

    @Override
    public boolean saveObiect(Entities e) {

        factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(this.entities.getClass()).buildSessionFactory();

        session = factory.getCurrentSession();

        try {

            System.out.println("Creating object  .... ");


            session.beginTransaction();

            session.save(e);

            session.getTransaction().commit();

            System.out.println("Done!");

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            factory.close();
        }

    }

    @Override
    public boolean deleteObject(Long id) {

        factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(this.entities.getClass()).buildSessionFactory();

        session = factory.getCurrentSession();

        try {

            System.out.println("Deleting object  .... ");

            session.beginTransaction();

            Entities e =  session.get(this.entities.getClass(), id);

            session.delete(e);

            session.getTransaction().commit();

            System.out.println("Done!");

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            factory.close();
        }


    }

    @Override
    public List<Entities> queryAllObject() {

        factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(this.entities.getClass()).buildSessionFactory();

        session = factory.getCurrentSession();

        List<Entities> entities = null;

        try {

            System.out.println("Quering objects  .... ");

            session.beginTransaction();

            entities = session.createQuery("from " + this.entities.getClass().getName() + "").getResultList();

            session.getTransaction().commit();

            System.out.println("Done!");

            return entities;

        } catch (Exception ex) {
            ex.printStackTrace();
            return entities;
        } finally {
            factory.close();
        }

    }


}
