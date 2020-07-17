<%-- 
    Document   : detail
    Created on : Jul 12, 2020, 10:33:54 PM
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
        &nbsp;
        <c:if test="${requestScope.DETAIL != null}">
            <div class="container">
                <div class="row">
                    <div class="col-4">
                        <img src="${requestScope.DETAIL.image}" class="img-fluid"/>
                    </div>
                    <div class="col-6">
                        <h1 class="text-center" style="color: orange">${requestScope.DETAIL.name}</h1>
                        <p class="h6 text-heading">${requestScope.DETAIL.description}</p>
                        <div class="row">
                            <span class="badge badge-primary">Total Times:</span> <span>${requestScope.DETAIL.time}</span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                     
                            <span class="badge badge-secondary">Serves: </span> <span>${requestScope.DETAIL.serves}</span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
                            <c:if test="${sessionScope.INFO != null}">
                                <c:if test="${requestScope.FAVO == null}">
                                    <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=new" class="btn btn-info">Add to Favorite</a>
                                </c:if>
                                <c:if test="${requestScope.FAVO.available == true}">
                                    <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=remove" class="btn btn-danger">Remove from Favorite</a>
                                </c:if>
                                <c:if test="${requestScope.FAVO.available == false}">
                                    <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=add" class="btn btn-info">Add to Favorite</a>
                                </c:if>
                            </c:if>
                        </div>                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <c:if test="${requestScope.DETAIL.ingredientCollection != null}">
                            <c:if test="${not empty requestScope.DETAIL.ingredientCollection}">
                                <h3>Ingredients</h3>
                                <c:forEach items="${requestScope.DETAIL.ingredientCollection}" var="ingredient" varStatus="counter">
                                    <c:choose>
                                        <c:when test="${ingredient.name.equals('For the Food')}">
                                            <h3 class="text-heading h3">No Ingredient Title</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h3 class="text-heading h3">${ingredient.name}</h3>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:if test="${ingredient.materialCollection != null}">
                                        <c:if test="${not empty ingredient.materialCollection}">
                                            <c:forEach items="${ingredient.materialCollection}" var="material" varStatus="counter">
                                                <p class="text-left">${material.unit} ${material.name}</p>
                                            </c:forEach> 
                                        </c:if>
                                    </c:if>                                
                                </c:forEach>
                            </c:if>
                        </c:if>
                    </div>    
                    <div class="col-6">                    
                        <c:if test="${requestScope.DETAIL.cakePreparations != null}">
                            <c:if test="${not empty requestScope.DETAIL.cakePreparations}">
                                <h3 class="text-heading text-center h3">Preparations</h3>
                                <c:forEach items="${requestScope.DETAIL.cakePreparations}" var="preparation" varStatus="counter">
                                    <p><span class="text-justify">${preparation.orderprepare}</span>. ${preparation.contentprepare}</p>
                                </c:forEach>
                            </c:if>
                        </c:if>
                    </div>
                </div>                
            </c:if>
        </div>
    </body>
</html>
