<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Attendance</title>
</head>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<body>
<table>
    <caption>Attendance</caption>
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Date</th>
        <th scope="col">Present</th>
    </tr>
    </thead>
    <tbody>
    <form action="user" method="post">
    <%@ page import="java.util.List" %>
    <%@ page import="com.codecool.web.model.User" %>
    <%@ page import="com.codecool.web.model.Attendance" %>
    <% List<User> users = (List<User>) request.getAttribute("users"); %>
    <% List<Attendance> attendance = (List<Attendance>) request.getAttribute("attendance"); %>
        <% for(User user : users) { %>
        <tr>
          <% if(!user.isMentor()) { %>
            <td scope="row"><%=user.getName()%></td>
          <%}%>
        <% for(Attendance attend : attendance) { %>

            <td><%=attendance.getDate()%></td>
            <td><select>
                  <option value="volvo">Present</option>
                  <option value="saab">Not Present</option>
                  <option value="mercedes">Late</option>
                </select>
            </td>
        <%}%>
        </tr>
        <% } %>
    </form>