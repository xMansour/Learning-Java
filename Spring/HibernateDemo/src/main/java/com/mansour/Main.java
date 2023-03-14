package com.mansour;

import com.mansour.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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

            //Insert/Create
            Student student = new Student("Tom", "Cruse", "TomCruse@test.com");
            Student student2 = new Student("Tom2", "Cruse2", "TomCruse@test.com");
            Student student3 = new Student("Tom3", "Cruse3", "TomCruse@test.com");
            Student student4 = new Student("Tom4", "Cruse4", "TomCruse@test.com");

            session.beginTransaction();
            session.save(student);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.getTransaction().commit();
            System.out.println("studentId = " + student.getId());


            //Read
            /*
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student tomCruse = session.get(Student.class, student.getId());
            session.getTransaction().commit();

            System.out.println("johnDoe = " + tomCruse);*/

            //Read
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
            System.out.println("students = " + students);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            students = session.createQuery("from Student where first_name = 'Mahmoud'").getResultList();
            session.getTransaction().commit();
            System.out.println("students = " + students);



            //Update
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Student mahmoud = session.get(Student.class, students.get(0).getId());
//            mahmoud.setEmail("Mahmoud@test.com");   //changed but still in memory
//            session.getTransaction().commit();      //persisted
//            System.out.println("students = " + students);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            students = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
            System.out.println("students = " + students);

            //Delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student where id = 2").executeUpdate();
            session.getTransaction().commit();
            System.out.println("students = " + students);



            //Delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student studentToDelete = session.get(Student.class, students.get(3).getId());
            session.delete(studentToDelete);
            session.getTransaction().commit();


            //Delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            students.forEach(session::delete);
            session.getTransaction().commit();
            System.out.println("students = " + students);


        } finally {

            sessionFactory.close();
        }
    }
}