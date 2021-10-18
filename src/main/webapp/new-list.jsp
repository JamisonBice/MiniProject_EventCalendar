<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>new list</title>
</head>

<h1>New List</h1>
<form action = "createNewListServlet" method="post">
<p>List Name: </p><input type="text" name = "listName"><br />

<p>Event Sort Name: </p><input type="text" name = "eventSortName"><br />

<p>Available Items:</p><br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.eventDate} | ${currentitem.eventType} | ${currentitem.eventName}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create list and Add Items">

</form>
<a href="index.html">Go add new events instead</a>
</body>
</html>
