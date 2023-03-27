package com.mansour;

import com.mansour.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
//        Course piano3 = session.get(Course.class, 13);
//        session.remove(piano3);


//        List<Instructor> instructors = session.createQuery("from Instructor ").getResultList();
//        System.out.println("instructors = " + instructors);

//        Query<Instructor> instructorQuery = session.createQuery("select i from Instructor i " +
//                "join fetch i.courses " +
//                "where i.id = :theInstructorId ", Instructor.class);
//        instructorQuery.setParameter("theInstructorId", 19);
//
//        Instructor instructor19 = instructorQuery.getSingleResult();
//        System.out.println("instructor19 = " + instructor19);


//        Course newCourse = new Course("Database");
//        newCourse.add(new Review("Awesome Course"));
//        newCourse.add(new Review("Recommended!"));
//        newCourse.add(new Review("Wow!"));

//        Course courseToDelete = session.get(Course.class, 15);
//        session.remove(courseToDelete);


//        Course course = new Course("JavaFX");
//        System.out.println("Saving the course...");
//        session.persist(course);
//
//        Student student1 = new Student("x1", "y1", "z1");
//        Student student2 = new Student("x2", "y2", "z2");
//
//
//        course.addStudent(student1);
//        course.addStudent(student2);
//
//        System.out.println("Saving students...");
//        session.persist(student1);
//        session.persist(student2);

        Student studentToDelete = session.get(Student.class, 13);
        session.remove(studentToDelete);


        session.getTransaction().commit();


//        Instructor instructor = new Instructor("Ahmed", "Hassan", "Hassan@hibernate.com");
//        Session session = sessionFactory.getCurrentSession();
//        session.getTransaction().begin();
//        session.persist(instructor);
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.getTransaction().begin();
//        Instructor instructorTemp = session.get(Instructor.class, instructor.getId());
//        System.out.println("instructorTemp = " + instructorTemp);
//        System.out.println("Adding two more courses to " + instructorTemp.getFirstName());
//        Course course1 = new Course("Piano 3");
//        Course course2 = new Course(("Swimming 3"));
//        instructorTemp.addCourse(course1);
//        instructorTemp.addCourse(course2);
//        session.persist(instructorTemp);
//        session.getTransaction().commit();


//        Instructor instructor = session.get(Instructor.class, 12);
//        System.out.println("instructor = " + instructor);
//        System.out.println("Adding two more courses to " + instructor.getFirstName());
//        Course course1 = new Course("Piano 2");
//        Course course2 = new Course(("Swimming 2"));
//        instructor.addCourse(course1);
//        instructor.addCourse(course2);
//        session.persist(instructor);
//        session.getTransaction().commit();

//        session = sessionFactory.getCurrentSession();
//        session.getTransaction().begin();
//        Instructor instructor2 = session.get(Instructor.class, 12);
//        //System.out.println("instructor2 = " + instructor2);
//        session.getTransaction().commit();


    }
}