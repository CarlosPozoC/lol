<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Buscar habilidad</title>
</head>
<body>
<br/>
<form action="/Champion_abilitiesSearch" method="post">
	<span>Rango_1:</span> <input type="number" id="rango_1" name="rango_1"> <br />
	<span>Rango_2:</span> <input type="number" id="rango_2" name="rango_2"> <br />
	<input type="submit">
</form>
<br/>
<a href="Champion_abilities/Champion_abilitiesList.jsp">Listado de campeones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>