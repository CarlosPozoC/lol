<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar campeon</title>
</head>
<body>
<br/>
<form action="/ChampionInsert" method="post">
	<span>Champion_name:</span> <input type="text" id="champion_name" name="champion_name"> <br />
	<span>Title:</span> <input type="text" id="title" name="title"> <br />
	<span>Lore:</span> <input type="text" id="lore" name="lore"> <br />
	<span>Tags:</span> <input type="text" id="tags" name="tags"> <br />
	<input type="submit">
</form>
<br/>
<a href="ChampionList.jsp">Listado de campeones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>