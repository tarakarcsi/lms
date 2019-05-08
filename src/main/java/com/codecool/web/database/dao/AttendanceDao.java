package com.codecool.web.database.dao;

import com.codecool.web.model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceDao extends AbstractDao{

    public AttendanceDao(Connection connection) {
        super(connection);
    }

    public void addAttendance(Attendance attendance) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO attendance(name, currentDate, present) VALUES (?,?,?);")) {
            preparedStatement.setString(1, attendance.getUser().getName());
            preparedStatement.setString(2, attendance.getDate());
            preparedStatement.setString(3, attendance.getPresent());
            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeAttendance(int userid, String date, String present) {
        try (PreparedStatement preparedStatement =
                 connection.prepareStatement("UPDATE attendance SET date = ?, present =?" +
                     "WHERE userId = '" + userid + "'")) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, present);
            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
