<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 26.01.18
  Time: 03:19
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
<h2>KALKULATOR</h2>
<%--@elvariable id="wood" type="pl.coderslab"--%>
<form method="post" action="#">
    Rodzaj obiektu do niszczenia:
    <select name="type">

        <option value="1">Okrąglak- MW bezpośrednio</option>
        <option value="2">Okrąglak - MW na obwodzie</option>
        <option value="3">Otwór wiertniczy</option>
        <option value="4">Wiązka pali</option>
        <option value="5">Krawędziak</option>

</select><br>
    Drewno: <input type="checkbox" name="mokre" value="mokre" onclick="document.getElementById('wet').style.display = this.checked ? 'block' : 'none'; this.form.elements['wet'].disabled = !this.checked" >mokre</input>

    <select   id="wet" style="display: none" disabled="disabled" name="wet" ><option value="0.8">Słabe</option>
    <option value="0.0">brak</option>
    <option value="1.25">Średniej twardości</option>
    <option value="2.0">Twarde</option>
    </select>
    <input type="checkbox" name="suche" value="suche" onclick="document.getElementById('dry').style.display = this.checked ? 'block' : 'none'; this.form.elements['dry'].disabled = !this.checked" >suche</input>

    <select   id="dry" style="display: none" disabled="disabled" name="dry" >
        <option value="0.0">brak</option>
        <option value="0.8">Słabe</option>
        <option value="1.0">Średniej twardości</option>
        <option value="1.6">Twarde</option>
    </select>
    Przekrój <input type="number" name="diametr" value="0"/><br>
    Długość <input type="number" name="length" value="0" /><br>
    Szerokośc <input type="number" name="width" value="0"/><br>

    <input type="submit" value="Oblicz">
</form>

</body>
</html>
