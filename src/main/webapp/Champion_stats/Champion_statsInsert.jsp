<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar stat</title>
</head>
<body>
<br/>
<form action="/Champion_statsInsert" method="post">
	<span>Champion:</span> <input type="number" id="champion" name="champion"> <br />
	<span>Stat_name:</span> <input type="text" id="stat_name" name="stat_name"> <br />
	<span>Stat_value:</span> <input type="number" id="stat_value" name="stat_value"> <br />
	<span>Modifier_per_level:</span> <input type="number" id="modifier_per_level" name="modifier_per_level"> <br />
	<input type="submit">
</form>
<br/>
<a href="Champion_stats/Champion_statsList.jsp">Listado de stats</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>