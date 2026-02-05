<%-- 
    Document   : login
    Created on : Jan 19, 2026, 10:17:04 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><b>Login System</b></h1>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="login">
            Username: <input type="text" name="txtUsername" required="required"
                            oninvalid="this.setCustomValidity('Please. Enter your Username!')" 
                            oninput="this.setCustomValidity('')"/><br/>
            Password: <input type="password" name="txtPassword" required ="required"
                            oninvalid="this.setCustomValidity('Please. Enter your Password!')" 
                            oninput="this.setCustomValidity('')"/><br/>
            <input type="submit" value="Login">
        </form>
        <%
            String message = request.getAttribute("message")+"";
            message = (message.equals("null"))?"":message;
        %>
    </body>
</html>
