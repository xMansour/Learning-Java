import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private String dbUrl;
    private String user;
    private String password;
    Properties properties;

    public DatabaseConnectionManager(String propertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(propertiesFile));
        dbUrl = properties.getProperty("dbUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password);
    }
}
