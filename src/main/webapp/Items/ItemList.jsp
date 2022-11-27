<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Items</title>
</head>
<body>
<h1>Listado de Items</h1>
<form action="/ItemList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Item_name</td><td>Effect</td></tr>
    <c:forEach items="${Items}" var="i">
        <tr>
            <td>${i.getId()}</td>
            <td>${i.getItem_name()}</td>
            <td>${i.getEffect()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>