<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="css/assignment.css">
    <meta charset="UTF-8">
    <title>Assignment</title>
</head>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<body>
<div id="caption">Assignment</div>
<div class="center-box" >
    <input placeholder="Assignment title...">
</div>
<div class="center-box">
    <h1>
    </h1>
    <textarea placeholder="Assignment text..." cols="70" rows="10"></textarea>
</div>
<div class="center-box">
</br>
    <input placeholder="Max score">
</div>
<div class="center-box">
    <button type="submit">Publish now</button>
    <button type="submit">Publish later</button><br/>
</div>

</body>
</html>
