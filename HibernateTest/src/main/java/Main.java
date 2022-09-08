import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        Employee employee = new Employee("Java", "Mansour@gmail.com", "Mahmoud", "Mansour", 1000);
        writeData(entityManagerFactory, employee);
        List<Employee> list = readData(entityManagerFactory);
        for (Employee emp : list) {
            System.out.println(emp.getId() + " " + emp.getFirstName() + " " + emp.getLastName()
                    + " " + emp.getEmail() + " " + emp.getDepartment() + " " + emp.getSalary());
        }
    }

    private static void writeData(EntityManagerFactory entityManagerFactory, Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static List<Employee> readData(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Employee> result = entityManager.createQuery( "from Employee", Employee.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
