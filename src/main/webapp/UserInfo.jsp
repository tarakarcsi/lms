<%@ page contentType="text/html; charset=UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <head>
      <link rel="stylesheet" href="css/UserInfo.css"></head>
      <header>
        <%@ include file="welcome.jsp"%>
        </header>
        <body>
          <div id="caption">Profile</div>
          <section id="profile">
            <div id="profile-img">
              <img src="images/IronProfile.jpg"></div>
              <form action="UserInfo" method="post">
                <label>Name:
                  <input type="text" name="name" value="${user.name}" style="padding: 3px; border-radius: 10px;"></label>
                  <br>
                    <br>
                      <div id="profile-text">
                        <p class="email">
                          <strong>E-mail:${user.getEmail()}</strong>
                        </p>
                        <p class="status">
                          <strong>Role:
                              <c:choose>
                                <c:when test="${user.isMentor()}">
                                  <select name="role">
                                  <option value="true" selected="selected">Mentor</option>
                                  <option value="false">Student</option>
                                  </select>
                                </c:when>
                                <c:otherwise>
                                  <select name="role">
                                  <option value="false" selected="selected">Student</option>
                                  <option value="true">Mentor</option>
                                </select>
                                </c:otherwise>
                              </c:choose>
                          </strong>
                        </p>
                      </div>
                      <div id="submit">
                        <input type="submit" value="Submit"></div>
                      </form>
                    </section>
                  </body>
                </html>
