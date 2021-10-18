<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {background-color: ghostwhite;}
h1   {color: steelblue;
  font-family: verdana;
  font-size: 250%;}
p    {color: yellowgreen;
  font-family: courier;
  font-size: 160%;
  margin: 1px 1px 1px 1px;}
td    {color: yellowgreen;
  font-family: courier;
  font-size: 160%;
  margin: 1px 1px 1px 1px;}
pre    {color: yellowgreen;
  font-family: courier;
  font-size: 160%;
  margin: 1px 1px 1px 1px;}
input[type=submit]{
  background-color: lightgreen; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}
input[type=submit]:hover{
  background-color: green; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}

a:link, a:visited {
  background-color: skyblue;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: steelblue;
}
</style>
<meta charset="ISO-8859-1">
<title>Event List</title>
</head>
<body>
	<form method = "post"action = "navigationServlet">
		<pre class="tab">Event Date   Event Type   Event Name</pre>
		<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.eventDate}</td>
			<td>${currentitem.eventType}</td>
			<td>${currentitem.eventName}</td>
		</tr>
		</c:forEach>
		</table>
			<input type ="submit" value = "edit" name="doThisToItem">
			<input type ="submit" value = "delete" name="doThisToItem">
			<input type ="submit" value = "add" name="doThisToItem">
	</form>
</body>
</html>