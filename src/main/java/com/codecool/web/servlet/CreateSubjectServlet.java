package com.codecool.web.servlet;

import com.codecool.web.database.dao.SubjectDao;
import com.codecool.web.model.Subject;
import com.codecool.web.model.User;
import com.codecool.web.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/addSubject")
public class CreateSubjectServlet extends AbstractServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = getConnection(req.getServletContext())) {

            SubjectDao subjectDao = new SubjectDao(connection);
            SubjectService subjectService = new SubjectService(subjectDao);

            String title = req.getParameter("title");
            String content = req.getParameter("content");
            boolean isPublished = Boolean.valueOf(req.getParameter("status"));


            Subject newSubject = new Subject(title, content, isPublished);
            subjectService.insertSubject(newSubject);
            req.setAttribute("subject", newSubject);
            req.getRequestDispatcher("addCurriculum.jsp").forward(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
