<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="css/userlistpage.css">
</head>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<body>
<table>
    <caption>User List</caption>
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Role</th>
    </tr>
    </thead>
    <tbody>
    <form action="user" method="post">
    <%@ page import="java.util.List" %>
    <%@ page import="com.codecool.web.model.User" %>
    <% List<User> users = (List<User>) request.getAttribute("users"); %>
        <% for(User user: users) { %>
        <tr>
            <td scope="row"><%=user.getName()%></td>
            <td><%=user.getEmail()%></td>
            <% if(user.isMentor()) { %>
            <td>Mentor</td>
            <%}else{ %>
            <td>Student</td>
            <%}%>
        </tr>
        <% } %>
    </form>
    </tbody>
</table>
</body>
</html>
