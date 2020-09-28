<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<h1>Welcome to home</h1>
<a href="list">Check Stock</a>
<a href="add">Add New Bike</a>
<a href="short">Shortlisting</a>
<a href="logout">Logout</a>
</body>
</html>