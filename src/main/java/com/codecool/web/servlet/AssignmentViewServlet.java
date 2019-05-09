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


@WebServlet("/assignmentView")
public class AssignmentViewServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(Connection connection = getConnection(req.getServletContext())) {

            AssignmentDao assignmentDao = new AssignmentDao(connection);
            AssignmentService assignmentService = new AssignmentService(assignmentDao);

            List<Assignment> assignments = assignmentService.findAssignments();
            req.setAttribute("assignments", assignments);
            req.getRequestDispatcher("assignmentView.jsp").forward(req,resp);
            //resp.sendRedirect("assignmentView.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
