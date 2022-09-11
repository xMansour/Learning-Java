import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("demo.properties");
        Connection connection = databaseConnectionManager.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);
        Customer customer1 = new Customer(null, "Ahmed", "Hassan", "Giza");
        Customer customer2 = new Customer(null, "Abelrahman", "Ezzat", "Behira");
        Customer customer3 = new Customer(null, "Khaled", "Samir", "Alexandria");
        Customer customer4 = new Customer(null, "Mahmoud", "Mansour", "Cairo");
        customerDAO.create(customer1);
        customerDAO.create(customer2);
        customerDAO.create(customer3);
        customerDAO.create(customer4);
        customerDAO.findAll().forEach(System.out::println);
       /* for (Customer cust : customerDAO.findAll()) {
            System.out.println(cust.toString());
        }*/
        System.out.println();
        System.out.println();
        //System.out.println(customerDAO.findById(4).toString());
        //customerDAO.delete(4);
        System.out.println(customerDAO.update(new Customer(5L, "Mahmoud", "Mansour", "Cairo")).toString());
        Customer cust = customerDAO.findById(2);
        cust.setFirstName("Abdo");
        System.out.println(customerDAO.update(cust));
        System.out.println();
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.println("Page Number: " + i);
            customerDAO.findAllPaged(5, i).forEach(System.out::println);
            System.out.println();
        }
    }
}
