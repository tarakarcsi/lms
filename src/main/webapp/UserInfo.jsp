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
<table width="400px" border=0>
    <tr style="background-color:Purple;">
        <td align="center"><b>Name: ${user.getName()}</b></td>
        <td align="center"><b>E-mail Address: ${user.getEmail()}</b></td>
        <td align="center"><b>Role: <c:choose>
                                         <c:when test="${user.isMentor()}">
                                            <p>Mentor</p>
                                         </c:when>
                                         <c:otherwise>
                                           <p>Student</p>
                                         </c:otherwise>
                                       </c:choose></b>
        </td>
    </tr>
    <tr>
        <td align="center"><div id="displayarea"></div></td>
        <td align="center"><div id="displayarea1"></div></td>
        <td align="center"><div id="asd"></div></td>
        <td align="center"><div id="asdasd"></div></td>
    </tr>
</table>
</body>
</html>
