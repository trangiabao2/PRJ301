<%-- 
    Document   : university-form
    Created on : Feb 2, 2026, 9:59:45 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="addUniversity" />
            ID: <input type="text" name="id" value="${u.id}" /><br/>
            Name: <input type="text" name="name" value="${u.name}" /><br/>
            ShortName: <input type="text" name="shortName" value="${u.shortName}" /><br/>
            Description: <input type="text" name="description" value="${u.description}" /><br/>
            FoundedYear: <input type="number" name="foundedYear" step="1" min="0" value="${u.foundedYear == 0 ? "" : u.foundedYear}" /><br/>
            Address: <input type="text" name="address" value="${u.address}" /><br/>
            City: <input type="text" name="city" value="${u.city}" /><br/>
            Region: <input type="text" name="region" value="${u.region}" /><br/>
            Type: <input type="text" name="type" value="${u.type}" /><br/>
            TotalStudents: <input type="number" name="totalStudents" step="1" min="0" value="${u.totalStudents == 0 ? "" : u.totalStudents}" /><br/>
            TotalFaculties: <input type="number" name="totalFaculties" step="1" min="0" value="${u.totalFaculties == 0 ? "" : u.totalFaculties}" /><br/>
            IsDraft: <input type="checkbox" name="isDraft" value="1" ${u.isDraft ? 'checked' : ''}/><br/>
            <br/>

            <input type="submit" value="Add New University">
            <a href="MainController?action=search&keywords=">
                <button type="button">
                    Cancel
                </button>
            </a>
        </form>

        <ul style="color: red; list-style-type: none; padding: 0;">
            <c:if test="${not empty requestScope.msg}">
                <li><b>Notice:</b> ${requestScope.msg}</li>
            </c:if>

            <c:forEach items="${listError}" var="e">
                <li>${e}</li> <br/>
            </c:forEach>
        </ul>
    </body>
</html>
