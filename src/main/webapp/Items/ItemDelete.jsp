<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado items</title>
</head>
<body>
<br/>
<form action="/ItemDelete" method="post">
	<span>Seguro que quiere borrar este item, ${item_name}</span>
	<input type="hidden" id="id" name="id" value="${id}">
	<br />
	<input type="submit">
</form>
<br/>
<a href="Items/ItemList.jsp">Listado de items</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>