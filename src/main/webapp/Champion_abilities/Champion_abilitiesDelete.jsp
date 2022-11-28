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
<br/>
<form action="/Champion_abilitiesDelete" method="post">
	<span>Seguro que quiere borrar la habilidad, ${champion_name}</span>
	<input type="hidden" id="id" name="id" value="${id}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Champion_abilities/Champion_abilitiesList.jsp">Listado de habilidades</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>