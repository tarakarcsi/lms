package com.codecool.web.servlet;

import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;
import com.codecool.web.model.User;
import com.codecool.web.model.UserList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.sendRedirect("login.html");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<User> userList = UserList.getInstance().getUserList();

        if (validateLogin(email, password)) {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", email);
            for (User user: userList) {
                if(user.getEmail().equals(email))
                {
                    req.getSession().setAttribute("user", user);
                }
            }
            resp.sendRedirect("welcome.jsp");

        } else {
            resp.sendRedirect("login.html");
        }

    }

    private boolean validateLogin(String email, String pwd) {
        for (User user : UserList.getInstance().getUserList()) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(pwd)) {
                    return true;
                }
            }
        }
        return false;
    }
}
