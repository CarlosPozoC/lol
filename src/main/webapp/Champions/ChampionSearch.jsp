<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Buscar campeon</title>
</head>
<body>
<br/>
<form action="/Champion_abilitiesSearch" method="post">
	<span>stat_name:</span> <input type="text" id="stat_name" name="stat_name"> <br />
	<span>condition:</span> <input type="text" id="condition" name="condition"> <br />
	<span>stat_value:</span> <input type="text" id="stat_value" name="stat_value"> <br />
	<input type="submit">
</form>
<br/>
<a href="Champions/ChampionSearchList.jsp">Listado de campeones y tip mediante stat (enviar informacion antes de entrar)</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>