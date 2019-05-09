package com.codecool.web.servlet;

import com.codecool.web.database.dao.AssignmentDao;
import com.codecool.web.database.dao.SubjectDao;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Subject;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/addAssignment")
public class AssignmentServlet extends AbstractServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = getConnection(req.getServletContext())) {

            AssignmentDao assignmentDao = new AssignmentDao(connection);
            AssignmentService assignmentService = new AssignmentService(assignmentDao);

            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int maxScore = Integer.parseInt(req.getParameter("maxScore"));
            boolean published = Boolean.valueOf(req.getParameter("status"));

            Assignment newAssignment = new Assignment(title, content, maxScore, published);
            assignmentService.insertAssignment(newAssignment);
            req.setAttribute("assignment", newAssignment);
            //req.getRequestDispatcher("viewAssignmentPage.jsp").forward(req,resp);
            resp.sendRedirect("assignment.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
