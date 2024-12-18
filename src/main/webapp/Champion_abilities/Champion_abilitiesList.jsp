<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado habilidades</title>
</head>
<body>
<h1>Listado habilidades</h1>
<form action="/Champion_abilitiesList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Champion</td><td>Champion_name</td><td>Champion_description</td><td>Effect</td><td>Cost</td><td>Rango</td></tr>
    <c:forEach items="${Champion_abilities}" var="ca">
        <tr>
            <td>${ca.getId()}</td>
            <td>${ca.getChampion()}</td>
            <td>${ca.getChampion_name()}</td>
            <td>${ca.getChampion_description()}</td>
            <td>${ca.getEffect()}</td>
            <td>${ca.getCost()}</td>
            <td>${ca.getRango()}</td>
            <td>
	            <form action="/Champion_abilitiesDelete" method="get">
	                    <input type="hidden" name="id" value="${ca.getId()}"/>
	                    <input type="hidden" name="champion_name" value="${ca.getChampion_name()}"/>
	                    <input value="Borrar" type="submit"/>
	            </form>
	        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>