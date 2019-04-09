package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.Serializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet implements Serializable {

    private List<User> userList = new ArrayList<>();
    private Serializer serializer = new Serializer();

    public List<User> getUserList(){
        return userList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String isMentor = req.getParameter("type");

        userList.add(new User(name, email, password, isMentor));
    }

    public void save() {
        try{
            serializer.saveUser(userList);
            System.out.println("User saved.");
        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
