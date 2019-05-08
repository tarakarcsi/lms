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

@WebServlet("/UserInfo")
public class UserInfoServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        resp.setContentType("text/html");
        req.getRequestDispatcher("UserInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        boolean isMentor = Boolean.valueOf(req.getParameter("role"));
        String newName = req.getParameter("name");
        user.setName(newName);
        user.setMentor(isMentor);

        try (Connection connection = getConnection(req.getServletContext())) {

            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            userService.updateUser(newName, isMentor, user.getEmail());
            req.setAttribute("user", user);
            doGet(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
