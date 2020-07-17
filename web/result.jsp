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
                            <center><h1>We found a cake that best match with your criteria</h1></center>
                            </c:otherwise>
                        </c:choose>
                    <div class="row">
                        <c:forEach items="${requestScope.RESULT}" var="items" varStatus="counter">
                            <div class="col-4 blog_item blog_info">                        
                                <a href="DetailController?id=${items.cake.id}"><img src="${items.cake.image}" class="img-fluid"/></a>
                                <a href="DetailController?id=${items.cake.id}" class="link" style="color: orange"><h3 class="text-heading">${items.cake.name}</h3></a>
                                <p><span class="badge badge-danger">Match point: </span>${items.point}</p>
                                <p><span class="badge badge-primary">Category: </span>${items.cake.categoryid.name}</p>
                                <p><span class="badge badge-secondary">Views: </span>${items.cake.views}</p>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </c:if>
            <c:if test="${requestScope.NEARMATCH != null}">
                <c:if test="${not empty requestScope.NEARMATCH}">
                    <center><h1>We found lots of cake that near match with your criteria</h1></center>
                    <div class="row">
                        <c:forEach items="${requestScope.NEARMATCH}" var="nearItems" varStatus="counter">
                            <div class="col-4 blog_item blog_info">                        
                                <a href="DetailController?id=${nearItems.cake.id}"><img src="${nearItems.cake.image}" class="img-fluid"/></a>
                                <a href="DetailController?id=${nearItems.cake.id}" class="link" style="color: orange"><h3 class="text-heading">${nearItems.cake.name}</h3></a>
                                <p><span class="badge badge-danger">Match point: </span>${nearItems.point}</p>
                                <p><span class="badge badge-primary">Category: </span>${nearItems.cake.categoryid.name}</p>
                                <p><span class="badge badge-secondary">Views: </span>${nearItems.cake.views}</p>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
