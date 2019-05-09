package com.codecool.web.servlet;

import com.codecool.web.database.dao.AttendanceDao;
import com.codecool.web.database.dao.UserDao;
import com.codecool.web.model.Attendance;
import com.codecool.web.model.User;
import com.codecool.web.service.AttendanceService;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@WebServlet("/attendance")
public class AttendanceServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {
            AttendanceDao attendanceDao = new AttendanceDao(connection);
            AttendanceService attendanceService = new AttendanceService(attendanceDao);
            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            List<User> users = userService.getUsers();
            for (User user : users) {
                System.out.println(user.getName());
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY - MM - dd");
            Date date = new Date(System.currentTimeMillis());
            String dateString =  dateFormat.format(date);
            req.setAttribute("date", dateString);
            req.setAttribute("users", users);
            req.getRequestDispatcher("attendance.jsp").forward(req, resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
