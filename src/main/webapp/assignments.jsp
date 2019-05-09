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
        <h2>${assignment.getTitle()} </h2>
        <p>${assignment.getContent()} </p>
    </c:if>
</div>
</body>

</html>
