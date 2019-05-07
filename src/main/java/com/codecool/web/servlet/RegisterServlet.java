package com.codecool.web.servlet;

import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.model.UserList;
import com.codecool.web.service.EmailService;
import com.codecool.web.service.Serializer;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/register")
public class RegisterServlet extends AbstractServlet {
    private List<User> userList = new ArrayList<>();
    private Serializer serializer = new Serializer();
    private EmailService es = new EmailService();


    public List<User> getUserList() {
        return userList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            String userId = req.getParameter("userId");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password1 = req.getParameter("password1");
            String password2 = req.getParameter("password2");
            Boolean isMentor = Boolean.valueOf(req.getParameter("type"));
            if (password1.equals(password2)) {
                User newUser = new User(name, email, password1, isMentor);
                userService.insertUser(newUser);
                resp.sendRedirect("login.html");
                save();
            } else {
                req.setAttribute("error", "error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            serializer.saveUser(userList);
            System.out.println("User saved.");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }
}
