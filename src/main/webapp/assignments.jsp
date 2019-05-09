<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Assignments</title>
    <link rel="stylesheet" href="css/subject.css">
</head>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<body>
    <c:set var="assignment" scope = "session" value = "${assignment}"/>
    <div  id="hero">
        <c:if test="${assignment.isPublished()}">
            <h2 id="h2">${assignment.getTitle()} </h2>
        </c:if>
    </div>
    <div class="center-boxI">
        <textarea id="tarea" name="content" placeholder="Write your answer..." cols="70" rows="10"></textarea>
    </div>
        <strong>
            <div class="center-boxII">
                <button id="aButton" type="submit" class="submit">Submit</button>
            </div>
        </strong>
    </div>
</body>
</html>
