<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar habilidad</title>
</head>
<body>
<br/>
<form action="/Champion_abilitiesInsert" method="post">
	<span>Id:</span> <input type="number" id="id" name="id"> <br />
	<span>Champion:</span> <input type="number" id="champion" name="champion"> <br />
	<span>Champion_name:</span> <input type="text" id="champion_name" name="champion_name"> <br />
	<span>Champion_description:</span> <input type="text" id="champion_description" name="champion_description"> <br />
	<span>Effect:</span> <input type="text" id="effect" name="effect"> <br />
	<span>Cost:</span> <input type="text" id="cost" name="cost"> <br />
	<span>Rango:</span> <input type="number" id="rango" name="rango"> <br />
	<input type="submit">
</form>
<br/>
<a href="Champion_abilities/Champion_abilitiesList.jsp">Listado de campeones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>