<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 03.02.18
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>

<div class="container-fluid" id="header">
    <jsp:include page="header.jsp"/>
</div>
<br>
<br>
<br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-xs-6">
            <%--@elvariable id="mine" type="pl"--%>
            <form:form method="post" action="${url}" modelAttribute="mine" enctype="multipart/form-data">
            <form:hidden path="id"/>
            <div class="form-group">
                <label for="name">Nazwa miny:</label>
                <form:input path="name" type="text" class="form-control" placeholder="nazwa miny"/><br>
                <form:errors path="name"/>
            </div>
            <div class="form-group">
                <label for="typeOfMine">Rodzaj miny:</label>
                <form:select path="typeOfMine" items="${typeOfMines}" itemLabel="name" itemValue="id"/>
            </div>

            <div class="form-group">
                <label for="photo">Zdjęcie miny:</label>
                <form:input path="photo" type="file" class="form-control-file"/>

            </div>
        </div>
        <div class="col-xs-6">
            <div class="form-group">
                <label for="mass">Masa miny:</label>
                <form:input path="mass" type="text" class="form-control" placeholder="masa miny" />
                <form:errors path="mass"/>
            </div>
            <div class="form-group">
                <label for="height">Wysokość miny: </label>
                <form:input path="height" type="number" class="form-control" placeholder="wysokość miny"/>
                <form:errors path="height"/>
            </div>
            <div class="form-group">
                <label for="diametrOfMine">Średnica miny: </label>
                <form:input path="diametrOfMine" type="text" class="form-control" placeholder="średnica miny"/>
                <form:errors path="diametrOfMine"/>
            </div>
            <div class="form-group">
                <label for="body">korpus miny: </label>
                <form:input path="body" type="text" class="form-control" placeholder="korpus miny"/>
                <form:errors path="body"/>
            </div>
            <div class="form-group">
                <label for="explosiveMaterial">Materiał wybuchowy: </label>
                <form:input path="explosiveMaterial" type="text" class="form-control" placeholder="materiał wybuchowy"/>
                <form:errors path="explosiveMaterial"/>
            </div>

        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-12">
            <div class="form-group">
                <label for="description">Opis miny</label>
                <form:textarea path="description" class="form-control" rows="5" cols="10"/>
                <form:errors path="description"/>
            </div>
        </div>
    </div>
    <div class="row justify-content-end">
        <sec:authorize access="isAuthenticated()">
            <p>Zatwierdzony: <form:checkbox path="approved" value="true"/></p>
            <form:errors path="description"/><br>
        </sec:authorize>
        <input type="submit" value="Dodaj" class="btn btn-secondary btn-lg"/>
        </form:form>
    </div>
</div>

</body>
</html>
