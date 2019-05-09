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
                          <% List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList"); %>
                            <% String date = (String) request.getAttribute("date"); %>
                              <% for(Attendance attendance : attendanceList) { %>
                                <% if(!attendance.getUser().isMentor()) { %>
                                  <tr>
                                    <td scope="row"><%=attendance.getUser().getName()%></td>
                                  <%}%>
                                  <td><%=attendance.getDate()%></td>
                                  <td style="text-align: center;">
                                    <input name = "currentDate" type = "hidden" value = "${attendance.getDate()}">
                                    <c:choose>
                                      <c:when test="${attendance.getPresent() == 'Present'}">
                                        <select style="width: 70%" name="presence">
                                          <option value="Present,"+"${attendance.getUser().getUserId()}" selected="selected">Present</option>
                                          <option value="Not Present,"+"${attendance.getUser().getUserId()}">Not Present</option>
                                          <option value="Late,"+"${attendance.getUser().getUserId()}">Late</option>
                                        </select>
                                      </c:when>
                                      <c:when test="${attendance.getPresent() == 'Not Present'}">
                                        <select style="width: 70%" name="presence">
                                          <option value="Present,"+"${attendance.getUser().getUserId()}">Present</option>
                                          <option value="Not Present,"+"${attendance.getUser().getUserId()}" selected="selected">Not Present</option>
                                          <option value="Late,"+"${attendance.getUser().getUserId()}">Late</option>
                                        </select>
                                      </c:when>
                                      <c:when test="${attendance.getPresent() == 'Late'}">
                                        <select style="width: 70%" name="presence">
                                          <option value="Present,"+"${attendance.getUser().getUserId()}">Present</option>
                                          <option value="Not Present,"+"${attendance.getUser().getUserId()}">Not Present</option>
                                          <option value="Late,"+"${attendance.getUser().getUserId()}" selected="selected">Late</option>
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
