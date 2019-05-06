package com.codecool.web.database.dao;

import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public User fetchUser(ResultSet rs) throws SQLException {
        String userId = rs.getString("userId");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Boolean role = Boolean.valueOf(rs.getString("type"));


        return new User(userId, name,email, password, role);

    }
}
