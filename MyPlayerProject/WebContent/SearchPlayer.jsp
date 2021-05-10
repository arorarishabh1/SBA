<%@page import="com.myproj.model.Player"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myproj.dao.PlayerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="SavePlayer.jsp"> save</a>
<a href="SearchPlayer.jsp"> search</a>
<a href="DeletePlayer.jsp"> delete</a>
<a href="UpdatePlayer.jsp"> update</a>




<form action="MyPlayerSearch">

Player Name : <input type="text" name="PlayerName">
<br>

 <input type="submit" value="search">
</form>
<table>

<tr>


<td> Player Name </td>
<td> Role </td>
<td> Style </td>
<td> Team </td>
</tr>


<%

PlayerDao dao=new PlayerDao();
ArrayList<Player> players= dao.getPlayer();


for(Player player:players)
{
out.print("<tr>");


out.print("<td> "+ player.getPlayerName()+" </td>");
out.print("<td> "+ player.getRole()+" </td>");

out.print("<td> "+ player.getStyle()+" </td>");
out.print("<td> "+ player.getTeam()+" </td>");
out.print("</tr>");

}

%>

</table>



</body>
</html>
