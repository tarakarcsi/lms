<%@ page contentType="text/html; charset=UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <!DOCTYPE html>
      <html lang="en" xmlns="http://www.w3.org/1999/html">
        <head>
          <link rel="stylesheet" href="css/assignment.css">
            <meta charset="UTF-8">
              <title>Assignment</title>
            </head>
            <body>
              <header>
                <%@ include file="welcome.jsp" %>
                </header>
                <div class="center-box">
                  <form action="addSubject" method="post">
                    <input name="title" placeholder="Curriculum Title..."><br></div>
                    <div class="center-box">
                      <textarea name="content" placeholder="Create curriculum page..." cols="70" rows="10"></textarea>
                    </div>
                    <div class="center-box">
                      <p class="status">
                        <strong>Status:
                          <c:choose>
                            <c:when test="${subject.isPublished()}">
                              <select name="status">
                                <option value="true" selected="selected">Published</option>
                                <option value="false">Unpublished</option>
                              </select>
                            </c:when>
                            <c:when test="${!subject.isPublished()}">
                              <select name="role">
                                <option value="false">Unpublished</option>
                                <option value="true" selected="selected">Published</option>
                              </select>
                            </c:when>
                          </c:choose>
                        </strong>
                      </p>
                      <div class="center-box">
                        <button type="submit">Submit</button>
                      </div>
                    </form>
                  </div>
                </body>
              </html>
