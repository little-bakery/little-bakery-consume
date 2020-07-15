<%-- 
    Document   : favorite
    Created on : Jul 14, 2020, 10:24:10 PM
    Author     : duong
--%>

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
    <center><h1>Your Favorite Collection</h1></center>
    <div class="container">
        <c:if test="${requestScope.RESULT != null}">
            <c:if test="${empty requestScope.RESULT}}">
                <h2>You did not have anything in collection</h2>
            </c:if>
            <c:if test="${not empty requestScope.RESULT}">
                <div class="row">
                    <c:forEach items="${requestScope.RESULT}" var="favorite" varStatus="counter">
                        <div class="col-4 blog_item blog_info">                        
                            <a href="DetailController?id=${favorite.cakeid.id}"><img src="${favorite.cakeid.image}" class="img-fluid"/></a>
                            <a href="DetailController?id=${favorite.cakeid.id}" class="link" style="color: orange"><h4 class="text-heading">${favorite.cakeid.name}</h4></a>                        
                            <p><span class="badge badge-primary">Category:</span> ${favorite.cakeid.categoryid.name}</p>
                            <p><span class="badge badge-secondary">Views:</span> ${favorite.cakeid.views}</p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </c:if>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>
