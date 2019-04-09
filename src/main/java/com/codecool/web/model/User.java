package com.codecool.web.model;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String name;
    private String password;
    private boolean isMentor;

    public User(String email, String name, String password, String type) {
        this.email = email;
        this.name = name;
        this.password = password;
        if(type.equals("student"))
            this.isMentor = false;
        else
            this.isMentor = true;
    }

    public User(String email, String password, boolean isMentor) {
        this.email = email;
        this.password = password;
        this.isMentor = isMentor;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isMentor() {
        return isMentor;
    }
}
