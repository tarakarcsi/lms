<%@ page contentType="text/html; charset=UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8">
          <title>Attendance</title>
          <link rel="stylesheet" href="css/userlistpage.css"></head>
          <header>
            <%@ include file="welcome.jsp" %>
            </header>
            <body>
              <table>
                <caption>Attendance</caption>
                <thead>
                  <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Present</th>
                  </tr>
                </thead>
                <tbody>
                  <form action="attendance" method="post">
                    <%@ page import="java.util.List" %>
                      <%@ page import="com.codecool.web.model.User" %>
                        <%@ page import="com.codecool.web.model.Attendance" %>
                          <% List<User> users = (List<User>) request.getAttribute("users"); %>
                            <% String date = (String) request.getAttribute("date"); %>
                              <% for(User user : users) { %>
                                <% if(!user.isMentor()) { %>
                                  <tr>
                                    <td scope="row"><%=user.getName()%></td>
                                  <%}%>
                                  <td><%=date%></td>
                                  <td style="text-align: center;">
                                    <%-- <select style="width: 70%">
                                      <option value="volvo">Present</option>
                                      <option value="opel">Not Present</option>
                                      <option value="mercedes">Late</option>
                                    </select> --%>
                                    <c:choose>
                                      <c:when test="${attendance.getPresent().equals("Present")}">
                                        <select name="presence">
                                          <option value="Present" selected="selected">Present</option>
                                          <option value="Not Present">Not Present</option>
                                          <option value="Late">Late</option>
                                        </select>
                                      </c:when>
                                      <c:when test="${attendance.getPresent().equals("Not Present")}">
                                        <select name="presence">
                                          <option value="Present">Present</option>
                                          <option value="Not Present" selected="selected">Not Present</option>
                                          <option value="Late">Late</option>
                                        </select>
                                      </c:when>
                                      <c:when test="${attendance.getPresent().equals("Late")}">
                                        <select name="presence">
                                          <option value="Present">Present</option>
                                          <option value="Not Present">Not Present</option>
                                          <option value="Late" selected="selected">Late</option>
                                        </select>
                                      </c:when>
                                    </c:choose>
                                  </td>
                                <%}%>
                              </tr>
                            </form>
                          </tbody>
                        </table>
                        <br>
                          <div class="center-box">
                            <button id="attendanceSubmit" type="submit">Submit</button>
                          </div>
                        </body>
                      </html>
