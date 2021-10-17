<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form action = "createNewListServlet" method="post">
List Name: <input type="text" name = "listName"><br />

Event Sort Name: <input type="text" name = "eventSortName"><br />

Available Items:<br />
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
