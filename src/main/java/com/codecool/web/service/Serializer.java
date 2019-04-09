package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.servlet.RegisterServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer {

    public void saveUser(List<User> userList) throws IOException {
        FileOutputStream foS = new FileOutputStream("./users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(foS);
        oos.writeObject(userList);
        oos.close();
        foS.close();
    }

}
