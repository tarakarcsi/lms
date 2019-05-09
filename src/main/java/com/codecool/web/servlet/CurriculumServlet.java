package com.codecool.web.servlet;

import com.codecool.web.database.dao.SubjectDao;
import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;
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
import java.util.List;

@WebServlet("/curriculum")
public class CurriculumServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(Connection connection = getConnection(req.getServletContext())) {
            SubjectDao subjectDao = new SubjectDao(connection);
            SubjectService subjectService = new SubjectService(subjectDao);
            List<Subject> subjectList = subjectService.findSubjects();
            User user =  (User) req.getSession().getAttribute("user");
            req.setAttribute("subjects", subjectList);
            req.setAttribute("user", user);
            req.getRequestDispatcher("curriculum.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
