<%-- 
    Document   : result
    Created on : Jul 12, 2020, 10:16:40 PM
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
            <c:if test="${requestScope.RESULT != null}">
                <c:if test="${not empty requestScope.RESULT}">
                    <c:choose>
                        <c:when test="${requestScope.RESULT.size() >= 2}">
                            <center><h1>We found a lot of cake based on your criteria</h1></center>
                        </c:when>
                        <c:otherwise>
                            <center><h1>We found a cake that match with your criteria</h1></center>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach items="${requestScope.RESULT}" var="items" varStatus="counter">
                        <div class="col-4 blog_item blog_info">                        
                            <a href="DetailController?id=${items.cake.id}"><img src="${items.cake.image}" class="img-fluid"/></a>
                            <a href="DetailController?id=${items.cake.id}" class="link" style="color: orange"><h3 class="text-heading">${items.cake.name}</h3></a>
                            <p><span class="badge badge-warning">Match point: </span>${items.point}</p>
                            <p><span class="badge badge-primary">Category: </span>${items.cake.categoryid.name}</p>
                            <p><span class="badge badge-secondary">Views: </span>${items.cake.views}</p>
                        </div>
                    </c:forEach>
                </c:if>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
