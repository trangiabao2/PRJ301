<%-- 
    Document   : a
    Created on : Jan 19, 2026, 10:08:45 AM
    Author     : ACER
--%>

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

        <c:if test="${empty sessionScope.user}">
            <c:redirect url="${URL.LOGIN_PAGE}"></c:redirect>
        </c:if>

        <h1>Welcome, ${sessionScope.user.fullname}</h1>
        <form action="ChucNang" method="POST">
            <label>Feature 1:</label>
            <input type="text" id="f1" name="F1" /><br/>
            
            <label>Feature 2:</label>
            <input type="text" id="f2" name="F2" /><br/>
            
            <label>Feature 3:</label>
            <input type="text" id="f3" name="F3" /><br/>
            
            <input type="submit" value="Submit" />
        </form>
        
        <form action="${URL.MAIN_CONTROLLER}" method="POST">
            <input type="submit" name="action" value="Search" />
        </form>
        
        <hr>
        <%-- Link này sẽ gửi action=logout về MainController --%>
        <form action="${URL.MAIN_CONTROLLER}" method="POST">
            <input type="hidden" name="action" value="logout">
            
            <input type="submit" value="Log Out">
        </form>
    </body>
</html>
