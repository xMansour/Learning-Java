package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private String dbUrl;
    private Properties properties;

    public DatabaseConnectionManager(String propertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(propertiesFile));
        dbUrl = properties.getProperty("dbUrl");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }
}
