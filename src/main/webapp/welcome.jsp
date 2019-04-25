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
  <form action = "welcome.jsp" method = "get">
    <div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="userlistpage">Users</a>
    <a href="UserInfo">Profile</a>
    <a id = "curriculum" href="curriculum">Curriculum</a>
      <c:choose>
        <c:when test="${user.isMentor() == true}">
            <a id = "mentormenu" href="mentormenu">Mentor Menu</a>
      </c:when>
      </c:choose>
      <a id="logout" href="login.html" name="logout">Logout</a>
    </div>
    <div class = "name">
    </div>
  </form>
</body>
</html>
