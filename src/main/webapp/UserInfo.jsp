<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="css/UserInfo.css">
</head>
<header>
    <%@ include file="welcome.jsp"%>
</header>
<body>
<div id="caption">Profile</div>
<section id="profile">
        <div id="profile-img">
            <img src="images/IronProfile.jpg">
        </div>
        <p class="name">${user.getName()}</p>
        <div id="profile-text">
            <p class="email"> <strong>E-mail:${user.getEmail()}</strong> </p>
            <p class="status"><strong>Role:<c:choose>
                                                          <c:when test="${user.isMentor()}">
                                                            Mentor
                                                          </c:when>
                                                          <c:otherwise>
                                                            Student
                                                          </c:otherwise>
                                                       </c:choose></strong></p>
        </div>
    </section>
</body>
</html>
