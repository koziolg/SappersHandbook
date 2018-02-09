<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 24.01.18
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<table>
    <tr>
        <td>Nazwa materiału wybuchowego:</td>
        <td>Opis materiału wybuchowego</td>
        <td>Zdjęcie materiału wybuchowego</td>
    </tr>
    <c:forEach items="${ems}" var="em">
        <tr>
            <td>${em.name}</td>
            <td>${em.description}</td>
            <td>${em.photo}</td>
            <td><a href="/em/update/${em.id}">EDYTUJ</a></td>
            <td><a href="/em/delete/${em.id}">USUN </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
