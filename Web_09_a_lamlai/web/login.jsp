<%-- 
    Document   : welcome
    Created on : Feb 5, 2026, 10:42:30 PM
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
        
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="login" />
            Username: <input type="hidden" name="txtUsername" required="required"
                             oninvalid="this.setCustomValidity('Please. Enter your Username!')" 
                             oninput="this.setCustomValidity('')"/> <br/>
            Password: <input type="hidden" name="txtPassword" required="required" accept="
                             oninvalid="this.setCustomValidity('Please. Enter your Password!')" 
                             oninput="this.setCustomValidity('')""/><br/>
            <input type="submit" name="Login">
        </form>
    </body>
</html>
