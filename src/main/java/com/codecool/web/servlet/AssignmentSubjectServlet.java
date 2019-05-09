package com.codecool.web.servlet;

import com.codecool.web.database.dao.AssignmentDao;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AssignmentSubjectServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            AssignmentDao assignmentDao = new AssignmentDao(connection);
            AssignmentService assignmentService = new AssignmentService(assignmentDao);

            String title = req.getParameter("title");
            Assignment assignment = assignmentService.findAssignment(title);
            req.setAttribute("assignment", assignment);
            req.getRequestDispatcher("assignments.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
