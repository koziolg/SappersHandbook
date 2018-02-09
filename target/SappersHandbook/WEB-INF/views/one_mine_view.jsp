<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 26.01.18
  Time: 14:14
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
<div class="container" style=" border: solid cornflowerblue 2px">
    <div class="row">
        <p class="font-weight-bold"> ${mine.name} </p><br>
    </div>
    <div class="row">
        <%--Dodać link do opisu typu min--%>
        <p>${mine.typeOfMine.name} </p>
    </div>
    <hr size="1"/>
    <div class="row">
        <div class="col-md-8">
            ${mine.description}
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            test
        </div>
        <div class="col-md-4">
            <div class="row" style=" border: solid cornflowerblue 2px">
                <div class="table-responsive">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="row"> Zdjęcie</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <img src="${mine.photo}" class="img-fluid" alt="Responsive image">
                                ${mine.photo}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style=" border: solid cornflowerblue 2px">
                <div class=table-responsive">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="row">Dane techniczne</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Masa:</th>
                            <td>${mine.mass}</td>
                        </tr>
                        <tr>
                            <th scope="row">Wysokość:</th>
                            <td>${mine.height}</td>
                        </tr>
                        <tr>
                            <th scope="row">Średnica:</th>
                            <td>${mine.diametrOfMine}</td>
                        </tr>
                        <tr>
                            <th scope="row">Korpus:</th>
                            <td>${mine.body}</td>
                        </tr>
                        <tr>
                            <th scope="row">Mw:</th>
                            <td>${mine.explosiveMaterial}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>
