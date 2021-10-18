<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Edit Event</title>
</head>
<body>
<h1>Edit a Event</h1>
<form action = "editEventServlet" method="post">
<p>Date:</p> <input type ="text" name = "genre" value= "${itemToEdit.eventDate}">
<br />
<p>Type:</p> <input type = "text" name = "eventType" value = "${itemToEdit.eventType}">
<br />
<p>Name:</p> <input type = "text" name = "eventName" value = "${itemToEdit.eventName}">
<br />
 <input type = "hidden" name = "id" value = "${itemToEdit.id}">
<input type="submit" value = "Save Edited Item">

</form>
</body>
</html>