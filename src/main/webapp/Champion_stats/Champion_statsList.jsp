<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado stats</title>
</head>
<body>
<h1>Listado stats</h1>
<form action="/Champion_statsList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Champion</td><td>Stat_name</td><td>Stat_value</td><td>Modifier_per_level</td></tr>
    <c:forEach items="${Champion_stats}" var="cs">
        <tr>
            <td>${cs.getChampion()}</td>
            <td>${cs.getStat_name()}</td>
            <td>${cs.getStat_value()}</td>
            <td>${cs.getModifier_per_level()}</td>
            <td>
                <form action="/Champion_statsDelete" method="get">
                    <input type="hidden" name="champion" value="${cs.getChampion()}"/>
                    <input type="hidden" name="stat_name" value="${cs.getStat_name()}"/>
                    <input value="Borrar" type="submit"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>