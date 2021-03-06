package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList ourInstance = new UserList();

    private List<User> userList;

    public static UserList getInstance() {
        return ourInstance;
    }

    private UserList() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public User findUserByEmail(String email) {

        for(User user : this.getUserList()) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
