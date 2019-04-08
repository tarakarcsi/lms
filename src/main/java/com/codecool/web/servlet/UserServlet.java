package com.codecool.web.servlet;

import com.codecool.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("user")
public class UserServlet extends HttpServlet {

    RegisterServlet rS = new RegisterServlet();
    List<User> userList = rS.getUserList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("users", userList);
        request.getRequestDispatcher("userlistpage.jsp").forward(request, response);
    }
}
