import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "jdbc";
        String password = "jdbc";
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password)) {
            //read(connection);
            //insert(connection, "Mansour", "Mahmoud", "MahmoudMansour@mail.com",
            //      "CSE", 1000);
            //read(connection);
            //update(connection, 14, "Mahmoud@mail.com");
            //read(connection);
            //delete(connection, 12);
            //read(connection);

            //insertWithPreparedStatements(connection, "xMansour", "xMahmoud", "MahmoudMansour@mail.com",
            //      "xCSE", 1000);
            //read(connection);
            //updateWithPreparedStatements(connection, 12, "Mansour@mail.com");
            //read(connection);
            //deleteWithPreparedStatements(connection, 13);
            //read(connection);
            read(connection);
            increaseSalaries(connection, 50000, "Engineering");
            read(connection);
            System.out.println("\n\nHR Department Count: " + getDepartmentCount(connection, "HR"));
            readResultSet(getEmployeesForDepartment(connection, "HR"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void read(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
        System.out.println("__________________________________________________________________________________________");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("id") + " " + resultSet.getString("last_name") +
                    " " + resultSet.getString("first_name") + " " + resultSet.getString("email") +
                    " " + resultSet.getString("department") + " " + resultSet.getString("salary"));
            System.out.println();
        }
        System.out.println("Data Read Successfully");
        System.out.println("__________________________________________________________________________________________");

    }

    private static void readResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println("__________________________________________________________________________________________");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + " " + resultSet.getString("last_name") +
                        " " + resultSet.getString("first_name") + " " + resultSet.getString("email") +
                        " " + resultSet.getString("department") + " " + resultSet.getString("salary"));
                System.out.println();
            }
            System.out.println("Data Read Successfully");
            System.out.println("__________________________________________________________________________________________");
        }
    }

    private static void insert(Connection connection, String lastName, String firstName, String email,
                               String department, double salary) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(String.format("INSERT INTO EMPLOYEES(LAST_NAME, FIRST_NAME, EMAIL, DEPARTMENT, SALARY) VALUES" +
                "('%s','%s','%s','%s',%.2f)", lastName, firstName, email, department, salary));
        //int rowsAffected = statement.executeUpdate("INSERT INTO EMPLOYEES(LAST_NAME, FIRST_NAME, EMAIL, DEPARTMENT, SALARY) VALUES" +
        //"('Mansour', 'Mahmoud', 'MahmoudMansour@mail.com', 'CSE', 5446512.226)");
        System.out.println("Data Inserted Successfully, Rows Affected: " + rowsAffected);

    }

    private static void insertWithPreparedStatements(Connection connection, String lastName, String firstName, String email,
                                                     String department, double salary) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO EMPLOYEES(LAST_NAME, FIRST_NAME, " +
                "EMAIL, DEPARTMENT, SALARY) VALUES(?,?,?,?,?)");
        statement.setString(1, lastName);
        statement.setString(2, firstName);
        statement.setString(3, email);
        statement.setString(4, department);
        statement.setDouble(5, salary);
        int rowsAffected = statement.executeUpdate();
        System.out.println("Data Inserted Successfully, Rows Affected: " + rowsAffected);

    }

    private static void update(Connection connection, int id, String newEmail) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(String.format("UPDATE EMPLOYEES SET EMAIL = '%s' WHERE id=%d", newEmail, id));
        System.out.printf("Employee With ID = %d Updated Successfully%n", id);
    }

    private static void updateWithPreparedStatements(Connection connection, int id, String newEmail) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE EMPLOYEES SET EMAIL = ? WHERE id = ?");
        statement.setString(1, newEmail);
        statement.setInt(2, id);
        statement.executeUpdate();
        System.out.printf("Employee With ID = %d Updated Successfully%n", id);
    }

    private static void delete(Connection connection, int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(String.format("DELETE FROM EMPLOYEES WHERE id > %d", id));
    }

    private static void deleteWithPreparedStatements(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE id > ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private static void increaseSalaries(Connection connection, double increaseAmount, String department) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{ call increase_salaries(?,?) }");
        callableStatement.setDouble(1, increaseAmount);
        callableStatement.setString(2, department);
        callableStatement.execute();

    }

    private static int getDepartmentCount(Connection connection, String department) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{ call get_count_for_department(?,?)}");
        callableStatement.setString(1, department);
        callableStatement.registerOutParameter(2, Types.INTEGER);
        callableStatement.execute();
        return callableStatement.getInt(2);
    }

    private static ResultSet getEmployeesForDepartment(Connection connection, String department) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{ call get_employees_for_department(?)}");
        callableStatement.setString(1, department);
        callableStatement.execute();
        return callableStatement.getResultSet();
    }
}
