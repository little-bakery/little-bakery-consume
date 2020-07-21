<%-- 
    Document   : recipes
    Created on : Jul 7, 2020, 8:02:10 PM
    Author     : duong
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
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
            <div>
                <form class="col-sm-12" action="SearchAllController" method="POST">                                        
                    Search: <input type="text" name="txtSearch" class="col-sm-4" placeholder="Base on Name"/>                    
                    <c:if test="${applicationScope.CATEGORY != null}">
                        <c:if test="${not empty applicationScope.CATEGORY}">
                            <label for="cars" class="col-sm-4">Choose a type of cake:</label>
                            <select name="category" class="col-sm-2">
                                <c:forEach items="${applicationScope.CATEGORY}" var="category" varStatus="counter">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select> 
                        </c:if>
                    </c:if>                    
                    <input type="submit" class="col-sm-2" value="Search" name="actionButton"/>
                </form>
            </div>            
            <c:if test="${requestScope.RESULT != null}">
                <c:if test="${not empty requestScope.RESULT}">
                    <c:set var="doc" value="${requestScope.RESULT}"/>
                    <x:set var="result" select="$doc//cakeDtoes"/>
                    <div class="row" id="cakeTable">
                        <x:forEach select="$result/cakeDto" var="cake" varStatus="counter">
                            <div class="col-4 blog_item blog_info">                        
                                <a href="DetailController?id=<x:out select="$cake/id"/>"><img src="<x:out select="$cake/image"/>" class="img-fluid"/></a>
                                <a href="DetailController?id=<x:out select="$cake/id"/>" class="link" style="color: orange"><h3 class="text-heading"><x:out select="$cake/name"/></h3></a>
                                <p><span class="badge badge-primary">Category: </span><x:out select="$cake/categoryid/name"/></p>
                                <p><span class="badge badge-secondary">Views: </span><x:out select="$cake/views"/></p>
                            </div>
                        </x:forEach>
                    </div>
                </c:if>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </body> 
</html>
