<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar tip</title>
</head>
<body>
<br/>
<form action="/Champion_tipsInsert" method="post">
	<span>Id:</span> <input type="number" id="id" name="id"> <br />
	<span>Champion:</span> <input type="number" id="champion" name="champion"> <br />
	<span>Tip:</span> <input type="text" id="tip" name="tip"> <br />
	<input type="submit">
</form>
<br/>
<a href="Champion_tips/Champion_tipsList.jsp">Listado de tips</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>