<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>
      <title>Curriculum Page</title>
       <link rel="stylesheet" type="text/css" href="css/curriculum.css">
    </head>
    <header>
        <%@ include file="welcome.jsp" %>
    </header>
    <body>
    <div id="caption">Curriculum</div>
      <ul>
          <c:forEach  items="${subjects}" var="subject">
          <c:if test="${subject.isPublished()}">
            <li>
              <a href="content?title=${subject.getTitle()}">${subject.getTitle()}</a>
            </li>
            </c:if>
          </c:forEach>
      </ul>
    </body>
</html>
