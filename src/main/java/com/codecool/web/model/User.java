package com.codecool.web.model;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String name;
    private String password;
    private String password2;
    private boolean isMentor;

    public User(String name, String email, String password, String password2, String type) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.password2 = password2;
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

    public String getPassword2() {
        return password2;
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
