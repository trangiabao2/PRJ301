<%-- 
    Document   : a
    Created on : Jan 19, 2026, 10:08:45 AM
    Author     : ACER
--%>

<%@page import="Model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO u = (UserDTO) session.getAttribute("user");
            if (u != null) {
        %>

        <h1>Welcome, <%=u.getFullname()%></h1>
        <form action="ChucNang" method="POST">
            <label>Feature 1:</label>
            <input type="text" id="f1" name="F1" /><br/>
            
            <label>Feature 2:</label>
            <input type="text" id="f2" name="F2" /><br/>
            
            <label>Feature 3:</label>
            <input type="text" id="f2" name="F3" /><br/>
            
            <input type="submit" value="Submit" />
        </form>
        <a href="search.jsp">Seach</a>

        <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
        <hr>
        <%-- Link này sẽ gửi action=logout về MainController --%>
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="logout">

            <input type="submit" value="Log Out">
        </form>
    </body>
</html>
