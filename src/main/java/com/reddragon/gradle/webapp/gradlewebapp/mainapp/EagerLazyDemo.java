package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Course;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass((InstructorDetail.class))
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

           int theId = 5;

           session.beginTransaction();

           Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("[ > Instruktor < ] : " + instructor);

            System.out.println("[> Courses <] : " + instructor.getCourses());

            session.getTransaction().commit();

             session.close();


            System.out.println("After close ! [> Courses <] : " + instructor.getCourses());

            System.out.println("Done !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }

}
