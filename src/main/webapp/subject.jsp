<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Curriculum Page</title>

</head>
<body>
<c:set var="subject" scope = "session" value = "${subject}"/>
<h2>${subject.getTitle()} </h2>
<p>${subject.getContent()} </p>
</body>

</html>