<%-- 
    Document   : search
    Created on : Jan 25, 2026, 9:33:07 PM
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
        <!-- <--%@include  file="welcome.jsp" %> -->

        <c:if test="${empty sessionScope.user}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <jsp:include page="welcome.jsp" />
        
        <form action="${URL.MAIN_CONTROLLER}" method="GET">
            <input type="hidden" name="action" value="search"/>
            Input name: <input type="text" name="keywords" value="${requestScope.keywords}" />
            <input type="submit" name="action" value="search"/>
        </form>

        <hr/>
        <table border="1" width="100%">
            <thead>
            <th>Id</th>
            <th>Name</th>
            <th>Short Name</th>
            <th>City</th>
            <th>Region</th>
            <th>Type</th>
            <th>Founded Year</th>
            <th>Students</th>
            <th>Faculties</th>
            <th colspan="2">Action</th>
        </thead>

        <c:choose>
            <c:when test="${empty requestScope.list}">
                <tr>
                    <td colspan="11" style="text-align: center">
                        No data matching the search criteria found!
                    </td>
                </tr>
            </c:when>

            <c:otherwise>
                <c:forEach items="${requestScope.list}" var="listUniversityDTO">
                    <tr>
                        <td>${listUniversityDTO.id}</td>
                        <td>${listUniversityDTO.name}</td>
                        <td>${listUniversityDTO.shortName}</td>
                        <td>${listUniversityDTO.city}</td>
                        <td>${listUniversityDTO.region}</td>
                        <td>${listUniversityDTO.type}</td>
                        <td>${listUniversityDTO.foundedYear}</td>
                        <td>${listUniversityDTO.totalStudents}</td>
                        <td>${listUniversityDTO.totalFaculties}</td>
                        <td>
                            <c:if test="${listUniversityDTO.isDraft}">
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="id" value="${listUniversityDTO.id}">
                                    <input type="hidden" name="keywords" value="${requestScope.keywords}">
                                    <input type="submit" name="action" value="Update">
                                </form>
                            </c:if>
                        </td>
                        <td>
                            <form action="MainController" method="POST"
                                  onsubmit="return confirm('Bạn có chắc chắn muốn xóa trường đại học này không?');">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="id" value="${listUniversityDTO.id}" />
                                <input type="hidden" name="keywords" value="${requestScope.keywords}" />
                                <input type="submit" value="Delete" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>

    </table>

</body>
</html>
