package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Course;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesReviewerDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Course course = new Course("Programowanie dla zaawansowanych Spring 5.20");

            course.addReviews(new Review("Super kurs POLECAM"));
            course.addReviews(new Review("Raczej do dupy ;("));

            session.beginTransaction();

            session.save(course);

            session.getTransaction().commit();

            System.out.println("Course : " + course);
            System.out.println("[>Reviw<]: " + course.getReviews());

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }

}
