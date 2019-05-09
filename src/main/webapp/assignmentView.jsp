<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Assignment Page</title>
        <link rel="stylesheet" type="text/css" href="css/curriculum.css">
    </head>
    <header>
        <%@ include file="welcome.jsp" %>
    </header>
    <body>
        <div id="caption">Assignments</div>
            <ul style="width: 50%; margin: 0 auto;">
            <c:forEach items="${assignments}" var="assignment">
                <c:choose>
                    <c:when test="${(!assignment.isPublished() || assignment.isPublished()) && user.isMentor()}">
                        <li>
                            <a href="assign?title=${assignment.getTitle()}">${assignment.getTitle()}</a>
                        </li>
                    </c:when>
                    <c:when test="${assignment.isPublished() && !user.isMentor()}">
                        <li>
                            <a href="assign?title=${assignment.getTitle()}">${assignment.getTitle()}</a>
                        </li>
                    </c:when>
                </c:choose>
            </c:forEach>
            </ul>
    </body>
</html>
