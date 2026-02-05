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
            <h1><b>Login System</b></h1>
            <form action="MainController" method="post">
                <div class="form-group">
                    <label for="user"> <b>Username:</b></label>
                    <input type="text" id="user" name="txtUsername" required>
                </div>

                <div class="form-group">
                    <label for="pass"><b>Password:</b></label>
                    <input type="password" id="pass" name="txtPassword" required/>
                </div>

                <input type="submit" value="Login">
            </form>
            <%
                String message = request.getAttribute("message")+""; // ep chuoi
                message = (message.equals("null"))?"":message;
            %>
            <span style="color:red"> <%=message%></span>
        </div>
    </body>
</html>
