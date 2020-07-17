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
        <div class="container">
            <h2>Register</h2>
            <form action="RegisterController" method="POST">
                <span class="text-right">Username: </span><input type="text" name="txtUsername" required="true"/> <br/>
                <span class="text-right">Password: </span><input type="password" name="txtPassword" required="true"/> <br/>
                <span class="text-right">Confirm Password: </span><input type="password" name="txtConfirm" required="true"/> <br/>
                <span class="text-right">FullName: </span><input type="text" name="txtFullName" required="true" /> <br/>
                <input type="submit" name="Submit" value="Submit" class="btn btn-info"/> <br/>
            </form>
            <c:if test="${requestScope.ERROR != null}">
                <p style="color: red;">${requestScope.ERROR}</p>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
