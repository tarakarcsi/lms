package com.codecool.web.database.dao;

import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao{


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

    public void addUser(User user) {

        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(userId, name, email, password, role) VALUES (?,?,?,?,?);")) {

            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, Boolean.valueOf(user.isMentor()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User fetchUser(ResultSet rs) throws SQLException {
        String userId = rs.getString("userId");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Boolean role = Boolean.valueOf(rs.getString("type"));


        return new User(userId, name,email, password, role);

    }

    public boolean validateLogin(String email, String password) {

        try(Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM users WHERE email = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;
        return false;
    }
}
