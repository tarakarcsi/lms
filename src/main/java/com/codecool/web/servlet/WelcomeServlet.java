package com.codecool.web.servlet;

import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/welcome")
public class WelcomeServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {

            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);


        } catch (SQLException e) {
            e.printStackTrace();

            req.getRequestDispatcher("welcome.jsp").forward(req, resp);

        } ;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

    }
}
