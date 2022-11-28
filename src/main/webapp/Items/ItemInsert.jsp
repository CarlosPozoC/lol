<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar item</title>
</head>
<body>
<br/>
<form action="/ItemInsert" method="post">
	<span>Id:</span> <input type="number" id="id" name="id"> <br />
	<span>Item_name:</span> <input type="text" id="item_name" name="item_name"> <br />
	<span>Effect:</span> <input type="text" id="effect" name="effect"> <br />
	<input type="submit">
</form>
<br/>
<a href="Items/ItemList.jsp">Listado de campeones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>