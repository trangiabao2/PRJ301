<%-- 
    Document   : login
    Created on : Jan 19, 2026, 10:17:04 AM
    Author     : ACER
--%>
<link rel="stylesheet" href="assets/css/CSS.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="assets/css/CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><b>Login System</b></h1>
        <form action="${URL.MAIN_CONTROLLER}" method="post">
            <input type="hidden" name="action" value="login">
            Username: <input type="text" name="txtUsername" required="required"
                            oninvalid="this.setCustomValidity('Please. Enter your Username!')" 
                            oninput="this.setCustomValidity('')"/><br/>
            Password: <input type="password" name="txtPassword" required ="required"
                            oninvalid="this.setCustomValidity('Please. Enter your Password!')" 
                            oninput="this.setCustomValidity('')"/><br/>
            <input type="submit" value="Login">
        </form>
        
        <c:if test="${not empty requestScope.message}">
            <span class="error-text">${requestScope.message}</span>
        </c:if>
    </body>
</html>
