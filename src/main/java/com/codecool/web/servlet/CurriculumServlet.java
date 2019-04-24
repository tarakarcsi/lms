package com.codecool.web.servlet;

import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/curriculum")
public class CurriculumServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        SubjectList.getInstance().addSubject(new Subject("berta", "adfasfgásnkldmfgáldnvséldbyfvndf-lbvyn", true));
        List<Subject> subjectList = SubjectList.getInstance().getSubjectList();
        req.setAttribute("subjects", subjectList);
        req.getRequestDispatcher("curriculum.jsp").forward(req, resp);
    }
}
