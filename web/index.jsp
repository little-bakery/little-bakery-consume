<%-- 
    Document   : index
    Created on : Jul 7, 2020, 7:59:21 PM
    Author     : duong
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
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
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}">
                <form action="SearchController" method="POST">
                    <c:forEach items="${requestScope.INFO.keySet()}" var="question" varStatus="counter">
                        <div>              
                            <h1>${question.name}</h1>                        
                            <c:choose>
                                <c:when test="${question.id == 1}">
                                    <c:forEach items="${requestScope.INFO.get(question)}" var="answer" varStatus="counter">
                                        <input type="checkbox" name="category" value="${answer.id}"/>
                                        <label for="category">${answer.name}</label><br/>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${question.id == 6}">
                                    <input type="number" placeholder="Type in here" name="serves"/>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${requestScope.INFO.get(question)}" var="answer" varStatus="counter">
                                        <input type="radio" name="ans${question.id}" value="${answer.id}"/> ${answer.name} <br/>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:forEach>
                    <input type="hidden" value="${requestScope.INFO.keySet().size()}" name="size"/>
                    <input type="submit" value="Submit" name="Search"/>
                </form>
            </c:if>
        </c:if>
        <%@include file="footer.jsp" %>
    </body>
</html>
