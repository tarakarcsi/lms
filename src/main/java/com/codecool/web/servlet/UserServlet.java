package com.codecool.web.servlet;

import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.model.UserList;
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

@WebServlet("/userlistpage")
public class UserServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = getConnection(request.getServletContext())) {
            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);

            response.setContentType("text/html;charset=UTF-8");
            List<User> userList = userService.getUsers();
            request.setAttribute("users", userList);
            request.getRequestDispatcher("userlistpage.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
