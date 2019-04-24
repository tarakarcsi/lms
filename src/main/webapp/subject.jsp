<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Curriculum Page</title>
    <link rel="stylesheet" href="css/subject.css">
</head>
<header>
    <%@ include file="welcome.html" %>
</header>
<body>
    <c:set var="subject" scope = "session" value = "${subject}"/>
    <div  id="hero">
        <h2>${subject.getTitle()} </h2>
        <p>${subject.getContent()} </p>
    </div>
</body>

</html>
