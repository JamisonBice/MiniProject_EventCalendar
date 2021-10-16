<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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