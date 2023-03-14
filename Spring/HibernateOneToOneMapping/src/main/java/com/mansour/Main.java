package com.mansour;

import com.mansour.entities.Instructor;
import com.mansour.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
//        String dbUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
//        String userName = "hbstudent";
//        String password = "hbstudent";
//
//        try{
//            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
//            System.out.println("Connection Okay...");
//
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
            Instructor instructor1 = new Instructor("Mahmoud", "Mansour", "Mahmoud@Spring.com");
            InstructorDetail instructor1Detail = new InstructorDetail("Mahmoud@Youtube.com", "Football");
            instructor1.setInstructorDetail(instructor1Detail);

            System.out.println("instructor1Detail.getInstructor() = " + instructor1Detail.getInstructor());


            SessionFactory sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(instructor1);
            session.getTransaction().commit();


//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.remove(instructor1);
//            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.remove(instructor1Detail);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}