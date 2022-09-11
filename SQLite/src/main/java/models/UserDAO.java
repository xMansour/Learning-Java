package models;

import util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DataAccessObject<User> {
    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public User findById(long id) {
        String getById = "SELECT * FROM USERS WHERE ID = ?";
        User user = null;
        try (PreparedStatement statement = this.connection.prepareStatement(getById)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;

    }

    @Override
    public List<User> readAll() {
        String select = "SELECT * FROM USERS";
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(select)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void create(User dto) {
        String INSERT = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, CITY) VALUES (?,?,?)";
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User dto) {
        String update = "UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, CITY = ? WHERE ID = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(update)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getCity());
            statement.setLong(4, dto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        String delete = "DELETE FROM USERS WHERE ID = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
