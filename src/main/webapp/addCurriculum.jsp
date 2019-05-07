<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="css/assignment.css">
    <meta charset="UTF-8">
    <title>Assignment</title>
</head>
<body>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<div class="center-box" >
    <form action="addSubject" method="post">
    <input placeholder="Curriculum Title...">
</div>
<div class="center-box">
    <textarea placeholder="Create curriculum page..." cols="70" rows="10"></textarea>
</div>
<div class="center-box">
    <button type="submit">Publish now</button>
    <button type="submit">Publish later</button><br/>
    </form>
</div>
</body>
</html>
