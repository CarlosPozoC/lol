<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado campeones y sus tips mediante la busqueda de stat</title>
</head>
<body>
<h1>Listado campeones y sus tips mediante la busqueda de stat</h1>
<form action="/ChampionSearch" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Champion_name</td><td>Title</td><td>Lore</td><td>Tags</td><td>Id</td><td>Champion</td><td>Tip</td></tr>
    <c:forEach items="${champions}" var="c">
    	<c:forEach items="${champion_tips}" var="ct">
	        <tr>
	             <td>${c.getId()}</td>
            	 <td>${c.getChampion_name()}</td>
            	 <td>${c.getTitle()}</td>
            	 <td>${c.getLore()}</td>
           		 <td>${c.getTags()}</td>
           		 <td>${ct.getId()}</td>
          	     <td>${ct.getChampion()}</td>
                 <td>${ct.getTip()}</td>
	        </tr>
	    </c:forEach>>
    </c:forEach>
</table>
</body>
</html>