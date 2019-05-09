package com.codecool.web.database.dao;

import com.codecool.web.model.Attendance;
import com.codecool.web.model.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDao extends AbstractDao {

    public AttendanceDao(Connection connection) {
        super(connection);
    }

    private UserDao userDao = new UserDao(connection);

    public void addAttendance(Attendance attendance) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO attendance(currentDate, present, userId) VALUES (?,?,?);")) {
            preparedStatement.setString(1, attendance.getDate());
            preparedStatement.setString(2, attendance.getPresent());
            preparedStatement.setInt(3, attendance.getUser().getUserId());
            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeAttendance(int userId, String date, String present) {
        try (PreparedStatement preparedStatement =
                 connection.prepareStatement("UPDATE attendance SET date = ?, present =?" +
                     "WHERE userId = '" + userId + "'")) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, present);
            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(fetchUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();

        String sql = "SELECT * FROM attendance  LEFT JOIN users ON attendance.userId=users.userId";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                attendanceList.add(fetchAttendance(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return attendanceList;

    }


    public User fetchUser(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Boolean role = rs.getBoolean("role");
        return new User(name, email, password, role);
    }

    private Attendance fetchAttendance(ResultSet rs) throws SQLException, ParseException {
        User user = userDao.getUserById(rs.getInt("userId"));
        String present = rs.getString("present");
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY - MM - dd");
        java.util.Date date =  dateFormat.parse(rs.getString("currentDate"));
        Date currentDate = new Date(date.getTime());
        return new Attendance(user, currentDate, present);
    }
}
