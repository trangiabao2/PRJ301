<%-- 
    Document   : a
    Created on : Jan 8, 2026, 2:42:55 PM
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
        <!--    for="..." la co the cho nguoi dung an vao "Feature 1"
                roi no tu dong chuyen qua o nhap lieu --> 
        <!--    for của label phải trùng khớp hoàn toàn với id của input-->
        <div class="container"> <h1>Feature Dashboard</h1>

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
        </div>
    </body>
</html>
