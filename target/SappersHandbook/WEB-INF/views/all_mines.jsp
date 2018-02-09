<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 24.01.18
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<div class="container-fluid" id="header">
    <jsp:include page="header.jsp"/>
</div>
<br>
<br>
<br>
<br>

<table>
    <tr>
        <td>Nazwa miny:</td>
        <td>Rodzaj miny:</td>
        <td>Dane techniczne miny:</td>
        <td>Opis miny</td>
        <td>Zdjęcie miny</td>
    </tr>
<sec:authorize access="isAnonymous()">
    <c:forEach items="${mines}" var="mine">

                <c:if test="${mine.approved != false && mine.approved != null}">
    <tr>
        <td>${mine.name}</td>
        <td>${mine.typeOfMine.name}</td>

        <td>${mine.description}</td>
        <td>${mine.photo}</td>
        <sec:authorize access="isAuthenticated()">
        <td><a href="/mine/update/${mine.id}">EDYTUJ</a></td>
        <td><a href="/mine/delete/${mine.id}">USUN </a></td>
        </sec:authorize>
    </tr>

    </c:if>

    </c:forEach>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

    <c:forEach items="${mines}" var="mine">

            <tr>
                <td>${mine.name}</td>
                <td>${mine.typeOfMine.name}</td>
                <td>${mine.description}</td>
                <td>${mine.photo}</td>
                <td>${mine.approved}</td>
                <td><a href="/mine/update/${mine.id}">EDYTUJ</a></td>
                <td><a href="/mine/delete/${mine.id}">USUN </a></td>
            </tr>



    </c:forEach>

</sec:authorize>
</table>
</body>
</html>
