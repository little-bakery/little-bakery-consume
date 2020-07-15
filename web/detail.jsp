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
        <c:if test="${requestScope.DETAIL != null}">
            <div>
                <div style="float: left;">
                    <img src="${requestScope.DETAIL.image}" width="300" height="300"/>
                </div>
                <div style="float: right;">
                    <h1>${requestScope.DETAIL.name}</h1>
                    <p>${requestScope.DETAIL.description}</p>
                    <div>
                        <p>Total Times: ${requestScope.DETAIL.time}</p>
                        <p>Serves: ${requestScope.DETAIL.serves}</p>
                    </div>
                </div>
            </div>
            <div>
                <div style="float: left;">
                    <c:if test="${requestScope.DETAIL.ingredientCollection != null}">
                        <c:if test="${not empty requestScope.DETAIL.ingredientCollection}">
                            <h3>Ingredient</h3>
                            <c:forEach items="${requestScope.DETAIL.ingredientCollection}" var="ingredient" varStatus="counter">
                                <c:choose>
                                    <c:when test="${ingredient.name.equals('For the Food')}">
                                        <h3>No Ingredient Title</h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3>${ingredient.name}</h3>
                                    </c:otherwise>
                                </c:choose>
                                <c:if test="${ingredient.materialCollection != null}">
                                    <c:if test="${not empty ingredient.materialCollection}">
                                        <c:forEach items="${ingredient.materialCollection}" var="material" varStatus="counter">
                                            <p>${material.unit} ${material.name}</p>
                                        </c:forEach> 
                                    </c:if>
                                </c:if>                                
                            </c:forEach>
                        </c:if>
                    </c:if>
                </div>    
                <div style="float: right;">                    
                    <c:if test="${requestScope.DETAIL.cakePreparations != null}">
                        <c:if test="${not empty requestScope.DETAIL.cakePreparations}">
                            <h3>Preparations</h3>
                            <c:forEach items="${requestScope.DETAIL.cakePreparations}" var="preparation" varStatus="counter">
                                <p>${preparation.orderprepare}. ${preparation.contentprepare}</p>
                            </c:forEach>
                        </c:if>
                    </c:if>
                </div>
            </div>
            <c:if test="${sessionScope.INFO != null}">
                <c:if test="${requestScope.FAVO == null}">
                    <div>
                        <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=new" class="btn btn-info">Add This Cake to your Favorite</a>
                    </div>
                </c:if>
                <c:if test="${requestScope.FAVO.available == true}">
                    <div>
                        <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=remove" class="btn btn-info">Remove This Cake From your Favorite</a>
                    </div>
                </c:if>
                <c:if test="${requestScope.FAVO.available == false}">
                    <div>
                        <a href="AddToFavoriteController?cakeid=${requestScope.DETAIL.id}&status=add" class="btn btn-info">Add This Cake to your Favorite</a>
                    </div>
                </c:if>
            </c:if>
        </c:if>
    </body>
</html>
