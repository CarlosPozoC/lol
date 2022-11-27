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
<h1>Listado tips</h1>
<form action="/Champion_tipsList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Champion</td><td>Tip</td></tr>
    <c:forEach items="${Champion_tips}" var="ct">
        <tr>
            <td>${ct.getId()}</td>
            <td>${ct.getChampion()}</td>
            <td>${ct.getTip()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>