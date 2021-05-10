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



<form action="DeletePlayerServlet">

Player Name : <input type="text" name="PlayerName">
<br>

 <input type="submit" value="Delete">
</form>

</body>
</html>