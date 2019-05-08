package com.codecool.web.database.dao;

import com.codecool.web.model.Assignment;
import com.codecool.web.model.Attendance;
import com.codecool.web.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDao extends AbstractDao {


    AssignmentDao(Connection connection) {
        super(connection);
    }

    public List<Assignment> getAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT * FROM assignments;";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                assignments.add(fetchAssignment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    public Assignment getAssignment(String title) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM assignments WHERE title = ?")) {
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String content = resultSet.getString("content");
                int maxScore = resultSet.getInt("maxScore");
                Boolean isPublished = resultSet.getBoolean("isPublished");

                return new Assignment(title, content, maxScore, isPublished);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NullPointerException();
    }

    public void addAssignment(Assignment assignment){

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO assignments(title, content, maxScore, isPublished) VALUES (?,?,?,?);")) {
            preparedStatement.setString(1, assignment.getTitle());
            preparedStatement.setString(2, assignment.getContent());
            preparedStatement.setInt(3, assignment.getMaxScore());
            preparedStatement.setBoolean(4, assignment.isPublished());

            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Assignment fetchAssignment(ResultSet resultSet) throws SQLException {
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        int maxScore = resultSet.getInt("maxScore");
        Boolean isPublished = resultSet.getBoolean("isPublished");

        return new Assignment(title, content, maxScore, isPublished);
    }

}
