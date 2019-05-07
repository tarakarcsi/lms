package com.codecool.web.database.dao;

import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {


    public UserDao(Connection connection) {
        super(connection);
    }


    public List<User> findUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(fetchUser(resultSet));
            }
        }
        return users;
    }

    public void addUser(User user) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, email, password, role) VALUES (?,?,?,?);")) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isMentor());
            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String email) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Boolean role = resultSet.getBoolean("role");

                return new User(name, email, password, role);

            }
        } catch (
            SQLException e) {
            e.printStackTrace();
        }
        throw new
            NullPointerException();
    }

    public User fetchUser(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Boolean role = rs.getBoolean("role");


        return new User(name, email, password, role);

    }

    public boolean validateLogin(String email, String password) {

        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM users WHERE email = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
