package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Course;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Instructor instructor = new Instructor("Susan","Public",
                    "susan.public@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com",
                    "Video Games");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done !");

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }



    }

}
