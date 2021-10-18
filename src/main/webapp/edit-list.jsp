<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">

<title>Edit An Existing Event List</title>
</head>
<h1>Edit a List </h1>
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
<p>List Name:</p> <input type ="text" name = "listName" value= "${listToEdit.listName}"><br />
<p>Event Sort Name:</p> <input type = "text" name = "eventSortName" value= "${listToEdit.eventSort.eventSortName}"><br />


<p>Available Items:</p><br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.eventDate} | ${currentitem.eventType} | ${currentitem.eventName}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">

</form>
<a href="index.html">Go add new events instead</a>
</body>
</html>
