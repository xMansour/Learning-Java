package com.mansour;

import com.mansour.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") //hibernate.cfg.xml could be removed since it is the default name
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            //Student student = new Student("Mahmoud", "Mansour", "MahmoudMansour@test.com");
            Student student2 = new Student("Patrick", "Bateman", "PatrickBateman@test.com");
            session.beginTransaction();
            //session.save(student);
            session.save(student2);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}