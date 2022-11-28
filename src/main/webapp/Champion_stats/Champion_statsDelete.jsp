<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado stats</title>
</head>
<body>
<br/>
<form action="/Champion_statsDelete" method="post">
	<span>Seguro que quiere borrar este stat, ${stat_name}</span>
	<input type="hidden" id="champion" name="champion" value="${champion}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Champion_stats/Champion_statsList.jsp">Listado de stats</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>