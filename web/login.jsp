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
        <div class="container text-center">
            <h2>Login</h2>
            <form action="LoginController" method="POST">
                <span class="text-right">Username: </span><input type="text" name="txtUsername" required="true" class="text-heading"/> <br/>
                <span class="text-right">Password: </span><input type="password" name="txtPassword" required="true" class="text-heading"/> <br/>
                <span class="text-heading"><input type="submit" name="Login" value="Login" class="btn btn-info"/> </span>
                <span class="text-right"><a href="register.jsp" class="text-center">Register here</a></span>
            </form>
            <c:if test="${requestScope.ERROR != null}">
                <p style="color: red;">${requestScope.ERROR}</p>
            </c:if>            
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
