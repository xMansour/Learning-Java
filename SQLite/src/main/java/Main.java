import models.User;
import models.UserDAO;
import util.DBManager;
import util.DatabaseConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("demo.properties");
        Connection connection = databaseConnectionManager.getConnection();
        DBManager dbManager = new DBManager(connection);
        dbManager.setupDB();
        UserDAO userDAO = new UserDAO(connection);
        userDAO.readAll().forEach(System.out::println);
        userDAO.create(new User(null, "Ahmed", "Ali", "Qalyoub"));
        System.out.println();
        userDAO.readAll().forEach(System.out::println);
        System.out.println();
        User user = userDAO.findById(1);
        user.setCity("Qahera");
        userDAO.update(user);
        System.out.println();
        userDAO.readAll().forEach(System.out::println);
        System.out.println();
        userDAO.delete(1);
        System.out.println();
        userDAO.readAll().forEach(System.out::println);
    }
}
