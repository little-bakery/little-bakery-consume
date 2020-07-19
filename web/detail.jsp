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
        <script type="text/javascript">
            var new_XMLDOM = null;
            <c:choose>
                <c:when test="${requestScope.FAVO == null}">
            var favor = null;
                </c:when>
                <c:otherwise>
            var favor = ${requestScope.FAVO.available};
                </c:otherwise>
            </c:choose>
            var update_status = null;
            var xmlHttp;

            function getXMLHttpObject() {
                var xmlHttp = null;
                try { // firefox, Opera, 8.0++, Safari
                    xmlHttp = new XMLHttpRequest();
                } catch (e) { // IE
                    try {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
            }

            function addToFavorite(id) {
                xmlHttp = getXMLHttpObject();
                if (xmlHttp === null) {
                    alert("Your browser dose not support AJAX");
                    return;
                }
                if (favor === null) {
                    update_status = 'New';
                } else {
                    if (favor === true) {
                        update_status = 'Remove';
                    } else {
                        update_status = 'Add';
                    }
                }
                xmlHttp.open("POST", "AddToFavoriteController", true);
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                var url = '';
                var cakeid = document.getElementById(id);
                if (update_status === 'New') {
                    url = 'cakeid=' + id + '&status=' + update_status;
                    cakeid.innerHTML = 'Remove from Favorite';
                    update_status = 'Remove';
                    cakeid.className = 'badge badge-danger';
                    favor = true;
                } else if (update_status === 'Remove') {
                    url = 'cakeid=' + id + '&status=' + update_status;
                    cakeid.innerHTML = 'Add to Favorite';
                    cakeid.className = 'badge badge-info';
                    update_status = 'Add';
                    favor = false;
                } else if (update_status === 'Add') {
                    url = 'cakeid=' + id + '&status=' + update_status;
                    update_status = 'Remove';
                    cakeid.innerHTML = 'Remove from Favorite';
                    cakeid.className = 'badge badge-danger';
                    favor = true;
                }
                xmlHttp.send(url);
            }
        </script>
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
                                    <button class="badge badge-info" id="${requestScope.DETAIL.id}" onclick="addToFavorite(${requestScope.DETAIL.id})" value="${requestScope.DETAIL.id}">Add to Favorite</button>
                                </c:if>
                                <c:if test="${requestScope.FAVO.available == true}">
                                    <button class="badge badge-danger" id="${requestScope.DETAIL.id}" onclick="addToFavorite(${requestScope.DETAIL.id})" value="${requestScope.DETAIL.id}">Remove from Favorite</button>
                                </c:if>
                                <c:if test="${requestScope.FAVO.available == false}">
                                    <button class="badge badge-info" id="${requestScope.DETAIL.id}" onclick="addToFavorite(${requestScope.DETAIL.id})" value="${requestScope.DETAIL.id}">Add to Favorite</button>
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
