package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Course;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass((InstructorDetail.class))
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            int iid = 5;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,iid);

            System.out.println("Instructor: " + instructor);

            System.out.println("\n Courses: " + instructor.getCourses());

            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }


}
