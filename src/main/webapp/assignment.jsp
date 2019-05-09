<%@ page contentType="text/html; charset=UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en" xmlns="http://www.w3.org/1999/html">
      <head>
        <link rel="stylesheet" href="css/assignment.css">
          <meta charset="UTF-8">
            <title>Assignment</title>
          </head>
          <header>
            <%@ include file="welcome.jsp" %>
            </header>
            <body>
              <div id="caption">Assignment</div>
              <div class="center-box">
                <form action="addAssignment" method="post">
                  <input name="title" placeholder="Assignment Title...">
                    <br>
                      <br></div>
                      <div class="center-box">
                        <textarea name="content" placeholder="Create Assignment..." cols="70" rows="10"></textarea>
                      </div>
                      <div class="center-box">
                        <p class="status" style="height: 100px;">
                          <input type="text" name="maxScore" placeholder="Max score" style="margin-bottom: 30px;">
                            <br>
                              <strong>Status:
                                    <select name="status">
                                      <option value="false">Unpublished</option>
                                      <option value="true">Published</option>
                                    </select>
                                <br>
                                  <div class="center-box">
                                    <button type="submit" class="submit">Submit</button>
                                  </div>
                                  </strong>
                                </div>
                              </p>
                            </form>
                          </div>
                        </div>
                      </body>
                    </html>
