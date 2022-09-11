import util.DataAccessObject;

import javax.swing.plaf.IconUIResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        String getById = "SELECT * FROM CUST WHERE ID = ?";
        Customer customer = null;
        try (PreparedStatement statement = this.connection.prepareStatement(getById)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return customer;

    }

    @Override
    public List<Customer> findAll() {
        String select = "SELECT * FROM CUST";
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(select)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return customers;
    }

    @Override
    public List<Customer> findAllPaged(int limit, int pageNumber) {
        String select = "SELECT * FROM CUST LIMIT ? OFFSET ?";
        int offset = pageNumber * limit;
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(select)) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return customers;
    }

    @Override
    public Customer create(Customer dto) {
        String INSERT = "INSERT INTO CUST (FIRST_NAME, LAST_NAME, HOME_TOWN) VALUES (?,?,?)";
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getHomeTown());
            statement.executeUpdate();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer update(Customer dto) {
        String update = "UPDATE CUST SET FIRST_NAME = ?, LAST_NAME = ?, HOME_TOWN = ? WHERE ID = ?";
        Customer customer = null;
        try (PreparedStatement statement = this.connection.prepareStatement(update)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getLastName());
            statement.setLong(4, dto.getId());
            statement.executeUpdate();
            customer = findById(dto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return customer;

    }

    @Override
    public void delete(long id) {
        String delete = "DELETE FROM CUST WHERE ID = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
