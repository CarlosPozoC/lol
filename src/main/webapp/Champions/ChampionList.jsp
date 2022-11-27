<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado campeones</title>
</head>
<body>
<h1>Listado campeones</h1>
<form action="/ChampionList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Champion_name</td><td>Title</td><td>Lore</td><td>Tags</td></tr>
    <c:forEach items="${Champions}" var="c">
        <tr>
            <td>${c.getId()}</td>
            <td>${c.getChampion_name()}</td>
            <td>${c.getTitle()}</td>
            <td>${c.getLore()}</td>
            <td>${c.getTags()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>