<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
<form action = "editEventServlet" method="post">
Date: <input type ="text" name = "genre" value= "${itemToEdit.eventDate}">
<br />
Type: <input type = "text" name = "eventType" value = "${itemToEdit.eventType}">
<br />
Name: <input type = "text" name = "eventName" value = "${itemToEdit.eventName}">
<br />
 <input type = "hidden" name = "id" value = "${itemToEdit.id}">
<input type="submit" value = "Save Edited Item">

</form>
</body>
</html>