package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private Connection connection;

    public DBManager(Connection connection) {
        this.connection = connection;
    }

    public void setupDB() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS USERS");
        statement.executeUpdate("CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT," +
                "LAST_NAME TEXT, CITY TEXT)");
        statement.executeUpdate("INSERT INTO USERS(FIRST_NAME, LAST_NAME, CITY) VALUES('Mahmoud', 'Mansour', 'Cairo')");
        statement.executeUpdate("INSERT INTO USERS(FIRST_NAME, LAST_NAME, CITY) VALUES('Khaled', 'Samir', 'Alexandria')");
        statement.executeUpdate("INSERT INTO USERS(FIRST_NAME, LAST_NAME, CITY) VALUES('Ahmed', 'Hassan', 'Giza')");
        statement.executeUpdate("INSERT INTO USERS(FIRST_NAME, LAST_NAME, CITY) VALUES('Abdelrahman', 'Sayed', 'Banha')");
        statement.executeUpdate("INSERT INTO USERS(FIRST_NAME, LAST_NAME, CITY) VALUES('Mohamed', 'Saeed', 'Farses')");
    }
}
