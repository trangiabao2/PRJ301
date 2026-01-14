<%-- 
    Document   : b
    Created on : Jan 8, 2026, 2:53:14 PM
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
            <h1 style="color: red;"><b>Login failed!</b></h1>
            <p>Invalid Username or Password.</p>
            <br/>
            <a href="login.jsp">Try Again</a>
        </div>
    </body>
</html>
