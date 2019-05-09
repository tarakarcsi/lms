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

    public void insertUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    public boolean checkIfRegistered(String email, String password) {
        return userDao.validateLogin(email, password);
    }

    public User findUser(String email) {
        return userDao.getUser(email);
    }

    public void updateUser(String name, boolean role, String email) {
        userDao.changeUserInfo(name, role, email);
    }

    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

}
