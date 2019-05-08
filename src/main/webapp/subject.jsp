<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Curriculum Page</title>
    <link rel="stylesheet" href="css/subject.css">
</head>
<header>
    <%@ include file="welcome.jsp" %>
</header>
<body>
    <c:set var="subject" scope = "session" value = "${subject}"/>
    <div  id="hero">
        <c:if test="${subject.isPublished()}">
            <h2>${subject.getTitle()} </h2>
            <p>${subject.getContent()} </p>
        </c:if>
    </div>
</body>

</html>
