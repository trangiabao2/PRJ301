<%-- 
    Document   : login
    Created on : Jan 8, 2026, 11:33:58 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Login System</h1>
            <form action="MainController" method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" name="txtUsername" required>
                </div>

                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="txtPassword" required/>
                </div>

                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
