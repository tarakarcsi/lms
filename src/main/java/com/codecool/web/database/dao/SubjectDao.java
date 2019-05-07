package com.codecool.web.database.dao;

import com.codecool.web.model.Subject;
import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao extends AbstractDao {


    SubjectDao(Connection connection) {
        super(connection);
    }

    public void addSubject(Subject subject) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subjets(title, content, isPublished) VALUES (?,?,?);")) {
            preparedStatement.setString(1, subject.getTitle());
            preparedStatement.setString(2, subject.getContent());
            preparedStatement.setBoolean(3, subject.isPublished());

            executeInsert(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subject getSubject(String title) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subjects WHERE title = ?")) {
            preparedStatement.setString(1, title);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String content = resultSet.getString("password");
                Boolean isPublished = resultSet.getBoolean("role");

                return new Subject(title, content, isPublished);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NullPointerException();
    }

    public List<Subject> getSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subjects;";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                subjects.add(fetchSubject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public Subject fetchSubject(ResultSet rs) throws SQLException {
        String title = rs.getString("title");
        String content = rs.getString("content");
        Boolean isPublished = rs.getBoolean("isPublished");

        return new Subject(title, content, isPublished);

    }
}
