<%-- 
    Document   : a
    Created on : Jan 8, 2026, 2:42:55 PM
    Author     : ACER
--%>

<%@page import="Model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>
        <%
            UserDTO u = (UserDTO) session.getAttribute("user");
            if (u != null) {
        %>

        <!--    for="..." la co the cho nguoi dung an vao "Feature 1"
                roi no tu dong chuyen qua o nhap lieu --> 
        <!--    for của label phải trùng khớp hoàn toàn với id của input-->
        <h1>Welcome, <%=u.getFullName()%></h1>

        <form action="ChucNang" class="feature-form">
            <div class="form-group">
                <label for="f1">Feature 1:</label>
                <input type="text" id="f1" name="F1">
            </div>

            <div class="form-group">
                <label for="f3">Feature 2:</label>
                <input type="text" id="f3" name="F3">
            </div>

            <div class="form-group">
                <label for="f2">Feature 3:</label>
                <input type="text" id="f2" name="F2">
            </div>

            <button type="submit">Submit</button>
        </form>

        <%  } else {
                response.sendRedirect("login.jsp");
            }
        %>

    </body>
</html>
