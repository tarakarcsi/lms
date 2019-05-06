package com.codecool.web.service;

import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() throws SQLException {
        return userDao.findUsers();
    }

    public void insertUser(User user) {
        userDao.addUser(user);
    }
}