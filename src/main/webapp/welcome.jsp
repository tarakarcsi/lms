<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <link rel="stylesheet" href="css/welcome.css">
</head>
<body>
  <form action = "welcome.html" method = "get">
    <div class="topnav">
      <c:choose>
        <c:when test="${isMentor == false}">
          <a class="active" href="#home">Home</a>
          <a href="userlistpage">Users</a>
          <a href="UserInfo">Profile</a>
          <a id = "curriculum" href="curriculum">Curriculum</a>
          <a id="logout" href="login.html" name="logout">Logout</a>
      </c:when>
      <c:otherwise>
        <a class="active" href="#home">Home</a>
        <a href="userlistpage">Users</a>
        <a href="UserInfo">Profile</a>
        <a id = "curriculum" href="curriculum">Curriculum</a>
        <a id = "mentormenu" href="mentormenu">Mentor Menu</a>
        <a id="logout" href="login.html" name="logout">Logout</a>
      </c:otherwise>
</c:choose>
    </div>
    <div class = "name">
    </div>
  </form>
</body>
</html>
