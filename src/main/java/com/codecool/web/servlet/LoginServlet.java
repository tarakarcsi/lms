package com.codecool.web.servlet;

import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;
import com.codecool.web.model.User;
import com.codecool.web.model.UserList;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.sendRedirect("login.html");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (Connection connection = getConnection(req.getServletContext())) {

            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (userService.checkIfRegistered(email, password)) {
                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                System.out.println("eljut");
                HttpSession newSession = req.getSession(true);
                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("email", email);

                User newUser = userService.findUser(email);
                req.getSession().setAttribute("user", newUser);
                resp.sendRedirect("welcome.jsp");

            } else {
                req.getRequestDispatcher("login.html").forward(req, resp);
            }
        } catch (
            SQLException ex) {
            ex.printStackTrace();
        }


    }
}
