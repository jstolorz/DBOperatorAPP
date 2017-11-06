package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int idi = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,idi);

            System.out.println("=>> ID " + instructorDetail);

            System.out.println("\n ==> I " + instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done !!");

        }catch (Exception exc){
            exc.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }

}
