<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado habilidades por rango</title>
</head>
<body>
<h1>Listado habilidades por rango</h1>
<form action="/Champion_abilitiesSearch" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Champion</td><td>Champion_name</td><td>Champion_description</td><td>Effect</td><td>Cost</td><td>Rango</td></tr>
    <c:forEach items="${Champion_abilitiesSearchList}" var="ca">
        <tr>
            <td>${ca.getId()}</td>
            <td>${ca.getChampion()}</td>
            <td>${ca.getChampion_name()}</td>
            <td>${ca.getChampion_description()}</td>
            <td>${ca.getEffect()}</td>
            <td>${ca.getCost()}</td>
            <td>${ca.getRango()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>