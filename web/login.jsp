<%-- 
    Document   : login
    Created on : Jul 14, 2020, 3:28:47 PM
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
        <form action="LoginController" method="POST">
            Username: <input type="text" name="txtUsername" /> <br/>
            Password: <input type="password" name="txtPassword"/> <br/>
            <input type="submit" name="Login" value="Login" /> <br/>
        </form>
        <c:if test="${requestScope.ERROR != null}">
            <p style="color: red;">${requestScope.ERROR}</p>
        </c:if>
            <a href="register.jsp">Register here</a>
    <%@include file="footer.jsp" %>
</body>
</html>
