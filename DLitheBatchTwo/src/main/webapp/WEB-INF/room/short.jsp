<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shortlisting Vehicle's</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<form action="shortlist" method="post">
<table>
<tr><td><input type="text" name="stkid" placeholder="Enter the stock id to fetch"></td></tr>
<tr><td><input type="text" name="milage" placeholder="Enter the milage fetch"></td></tr>
<tr><td><input type="text" name="cc" placeholder="Enter the Engine Capacity to fetch"></td></tr>
<tr><td><input type="text" name="price" placeholder="Enter the Price to fetch"></td></tr>
<tr>
<td><input type="submit" value="Read"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</body>
</html>