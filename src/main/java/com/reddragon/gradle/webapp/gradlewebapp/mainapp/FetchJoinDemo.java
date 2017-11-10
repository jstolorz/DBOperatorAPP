package com.reddragon.gradle.webapp.gradlewebapp.mainapp;

import com.reddragon.gradle.webapp.gradlewebapp.entities.Course;
import com.reddragon.gradle.webapp.gradlewebapp.entities.Instructor;
import com.reddragon.gradle.webapp.gradlewebapp.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try{

            int theId = 5;

            session.beginTransaction();

            Query<Instructor> instructorQuery = session.createQuery("" +
                      "select i from Instructor i "
                    + " JOIN FETCH  i.courses "
                    + "where i.id = :theInstructorId",
                    Instructor.class);

             instructorQuery.setParameter("theInstructorId",theId);

             Instructor instructor = instructorQuery.getSingleResult();

            session.getTransaction().commit();

            session.close();

            System.out.println("Session closed!!");

            System.out.println("[-Courses-]: " + instructor.getCourses());

            System.out.println("Done !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }
}
