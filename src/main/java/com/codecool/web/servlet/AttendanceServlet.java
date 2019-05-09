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
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@WebServlet("/attendance")
public class AttendanceServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Date date = Date.valueOf(req.getParameter("currentDate"));
            String[] array = req.getParameterValues("presence");
            AttendanceDao attendanceDao = new AttendanceDao(connection);
            AttendanceService attendanceService = new AttendanceService(attendanceDao);
            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            for (String element : array) {
                String present = element.split(",")[0];
                int id = Integer.parseInt(element.split(",")[1]);
                attendanceService.insertAttendance(new Attendance(userService.findUserById(id), date, present));
            }

            doGet(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            AttendanceDao attendanceDao = new AttendanceDao(connection);
            AttendanceService attendanceService = new AttendanceService(attendanceDao);
            UserDao userDao = new UserDao(connection);
            UserService userService = new UserService(userDao);
            List<Attendance> attendance = attendanceService.findAllAttendance();

            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY - MM - dd");
            req.setAttribute("attendanceList", attendance);
            req.getRequestDispatcher("attendance.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
