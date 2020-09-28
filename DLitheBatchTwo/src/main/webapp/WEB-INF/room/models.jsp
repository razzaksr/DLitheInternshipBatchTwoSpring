<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Only models</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div align="center">
<table border="4">
<tr><th>Matched Bike Models</th></tr>
<core:forEach var="mon" items="${all }">
<tr><td>${mon }</td></tr>
</core:forEach>
</table>
</div>
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</body>
</html>