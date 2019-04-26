package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.model.UserList;
import com.codecool.web.servlet.RegisterServlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

    public void saveUser(List<User> userList) throws IOException {
        FileOutputStream foS = new FileOutputStream("./users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(foS);
        oos.writeObject(userList);
        oos.close();
        foS.close();
    }
    @SuppressWarnings("unchecked")
    public List<User> readSer() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fiS = new FileInputStream("./users.ser");
            ObjectInputStream ois = new ObjectInputStream(fiS);
            List<User> userList = (List<User>) ois.readObject();
            ois.close();
            fiS.close();
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
