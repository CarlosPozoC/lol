<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado tips</title>
</head>
<body>
<br/>
<form action="/Champion_tipsDelete" method="post">
	<span>Seguro que quiere borrar este tip, ${tip}</span>
	<input type="hidden" id="id" name="id" value="${id}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Champion_tips/Champion_tipsList.jsp">Listado de tips</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>