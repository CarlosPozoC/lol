<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado campeones</title>
</head>
<body>
<br/>
<form action="/ChampionDelete" method="post">
	<span>Seguro que quiere borrar este campeon, ${champion_name}</span>
	<input type="hidden" id="id" name="id" value="${id}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Champions/ChampionList.jsp">Listado de campeones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>