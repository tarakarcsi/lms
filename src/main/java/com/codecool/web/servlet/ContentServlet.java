package com.codecool.web.servlet;

import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        Subject subject = SubjectList.getInstance().findByTitle(title);
        System.out.println(subject.getTitle());
        req.setAttribute("subject", subject);
        req.getRequestDispatcher("subject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
