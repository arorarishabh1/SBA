
<%@page import="com.myproj.model.Player"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<style type="text/css">

table {
background: #c95942;
}

td{
text-align: center;
width: 120px;
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="SavePlayer.jsp"> save</a>
<a href="SearchPlayer.jsp"> search</a>
<a href="DeletePlayer.jsp"> delete</a>
<a href="UpdatePlayer.jsp"> update</a>


<h1>
Student Details
</h1>


<table border='2px'>

<%! Player player; %>
<%player=(Player)session.getAttribute("player"); %>
<tr> <td>Player Name :</td> <td> <% out.print(player.getPlayerName()); %> </td> </tr>
<tr> <td>Role :</td> <td> <% out.print(player.getRole()); %></td> </tr>

<tr> <td>Style :</td> <td> <%out.print(player.getStyle()); %></td> </tr>
<tr> <td> Team :</td> <td> <%out.print(player.getTeam()); %></td> </tr>


</table>


</body>
</html>