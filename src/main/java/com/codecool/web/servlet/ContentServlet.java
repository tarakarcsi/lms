package com.codecool.web.servlet;

import com.codecool.web.database.dao.SubjectDao;
import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;
import com.codecool.web.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/content")
public class ContentServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {
            SubjectDao subjectDao = new SubjectDao(connection);
            SubjectService subjectService = new SubjectService(subjectDao);
            String title = req.getParameter("title");
            Subject subject = subjectService.findSubject(title);
            req.setAttribute("subject", subject);
            req.getRequestDispatcher("subject.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
