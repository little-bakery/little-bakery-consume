<%-- 
    Document   : favorite
    Created on : Jul 14, 2020, 10:24:10 PM
    Author     : duong
--%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
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
        <c:if test="${requestScope.DOC != null}">
            <c:set var="doc" value="${requestScope.DOC}"/>
            <x:set var="userCollection" select="$doc//favorites"/>
            <div class="row">
                <x:forEach select="$userCollection/favorite" var="favorite" varStatus="counter">
                    <div class="col-4 blog_item blog_info">                        
                        <a href="DetailController?id=<x:out select="$favorite/cakeid"/>"><img src="<x:out select="$favorite/image"/>" class="img-fluid"/></a>
                        <a href="DetailController?id=<x:out select="$favorite/cakeid"/>" class="link" style="color: orange"><h3 class="text-heading"><x:out select="$favorite/name"/></h3></a>                    
                        <p><span class="badge badge-primary">Category: <x:out select="$favorite/category"/></span></p>
                        <p><span class="badge badge-secondary">Views: <x:out select="$favorite/views"/></span></p>
                    </div>
                </x:forEach>
            </div>
        </c:if>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>
