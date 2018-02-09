<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 23.01.18
  Time: 14:41
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

    <title>Dodawnie miny</title>
</head>
<body>
<div class="container-fluid" id="header">
    <jsp:include page="header.jsp"/>
</div>
<br>
<br>
<br>

${head}
<%--@elvariable id="mine" type="pl"--%>
<form:form method="post" action="${url}" modelAttribute="mine"  >
    <form:hidden path="id"/>
    Nazwa miny: <form:input type="text" path="name" placeholder="Nazwa miny" aria-label="Nazwa miny" aria-describedby="basic-addon1"/><br>
    <form:errors path = "name" /><br>
    Rodzaj miny: <form:select type="text" path="typeOfMine" items="${typeOfMines}" itemLabel="name" itemValue="id"  aria-describedby="basic-addon1"/><br>
    Dane techniczene miny: <form:input type="text" path="specification" placeholder="Dane techniczne miny" aria-label="Nazwa miny" aria-describedby="basic-addon1"/><br>
    <form:errors path = "specification" /><br>
    Opis miny: <form:input type="text" path="description" placeholder="Opis miny" aria-label="Opis miny" aria-describedby="basic-addon1"/><br>
    <form:errors path = "description" /><br>
    Zdjęcie miny <form:input type="file" path="photo" placeholder="Zdjęcie miny" aria-label="Zdjęcie miny" aria-describedby="basic-addon1"/><br>

    <sec:authorize access="isAuthenticated()">
        <p>Zatwierdzony: <form:checkbox path="approved" value="true" /></p>
        <form:errors path = "description"/><br>
    </sec:authorize>

    <input type="submit" value="Dodaj"/>
</form:form>
<div class="g-recaptcha" data-sitekey="6Ld7oUIUAAAAAPDwDw5WqtNUzRSKTzzJMeEECFt2"></div>
</body>
</html>
