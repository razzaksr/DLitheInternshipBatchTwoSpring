<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle List</title>
</head>
<body>
${msg }
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sujith"%>
<table border="4" cellspacing="4" cellpadding="4">
<tr><th>ID</th><th>Model of Bike</th><th>Year of manufacture</th>
<th>Average Expected Milage</th><th>Vehicle Type</th><th>Engine Capacity</th>
<th>On Road Price</th><th>Available Quantity</th><th>Actions</th></tr>
<sujith:forEach var="hai" items="${all }">
<tr>
<td>${hai.getStkid() }</td><td>${hai.getModel() }</td><td>${hai.getYear() }</td>
<td>${hai.getMilage() }</td><td>${hai.getType() }</td><td>${hai.getCc() }</td>
<td>${hai.getPrice() }</td><td>${hai.getQuantity() }</td>
<td><ol type="A">
<li><a href="editable?id=${hai.getStkid() }">Edit</a></li>
<li><a href="deletable?id=${hai.getStkid() }">Delete</a></li>
</ol></td>
</tr>
</sujith:forEach>
</table>
</body>
</html>