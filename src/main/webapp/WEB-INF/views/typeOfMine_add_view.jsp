<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 24.01.18
  Time: 14:16
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
<br>
<br>
<br>

<%--@elvariable id="typeOfMine" type="pl.coderslab"--%>
<form:form method="post" action="${url}" modelAttribute="typeOfMine" >
    <form:hidden path="id"/>
    Rodzaj miny: <form:input type="text" path="name" placeholder="Rodzaj miny" aria-label="Rodzaj miny" aria-describedby="basic-addon1"/><br>
    <form:errors path = "name" /><br>
    Opis rodzaju miny: <form:input type="text" path="description" placeholder="rodzaju miny" aria-label="rodzaju miny" aria-describedby="basic-addon1"/><br>
    <form:errors path = "description" /><br>
    <input type="submit" value="Dodaj"/>
</form:form>
</body>
</html>
