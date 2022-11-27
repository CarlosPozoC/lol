<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Runas</title>
</head>
<body>
<h1>Listado de Runas</h1>
<form action="/RuneList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Tier</td><td>Rune_name</td><td>Rune_description</td></tr>
    <c:forEach items="${Runes}" var="r">
        <tr>
            <td>${r.getId()}</td>
            <td>${r.getTier()}</td>
            <td>${r.getRune_name()}</td>
            <td>${r.getRune_description()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>