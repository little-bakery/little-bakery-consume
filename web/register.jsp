<%-- 
    Document   : register
    Created on : Jul 14, 2020, 3:32:44 PM
    Author     : duong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Bakery</title>
        <link rel="icon" href="${pageContext.request.contextPath}/img/cake.png"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <form action="RegisterController" method="POST">
            Username: <input type="text" name="txtUsername" /> <br/>
            Password: <input type="password" name="txtPassword" /> <br/>
            Confirm Password: <input type="password" name="txtConfirm" /> <br/>
            FullName: <input type="text" name="txtFullName" /> <br/>
            <input type="submit" name="Submit" value="Submit" /> <br/>
        </form>
        <c:if test="${requestScope.ERROR != null}">
            <p style="color: red;">${requestScope.ERROR}</p>
        </c:if>
        <%@include file="footer.jsp" %>
    </body>
</html>
