package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Instructor instructor = new Instructor("Adam","Palet", "adam@tlen.pl");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "fishing");

            instructor.setInstructorDetail(instructorDetail);


            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done !!!");

        }finally {
            factory.close();
        }

    }
}
