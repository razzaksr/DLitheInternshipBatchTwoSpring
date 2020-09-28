<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Vehicle</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }
<%@ taglib prefix="dlithe" uri="http://www.springframework.org/tags/form" %>
<dlithe:errors path="vehicle.*"/>
<form action="newstock" method="post">
<table>
<tr><td><input type="text" name="model" placeholder="Enter the model of vehicle"></td></tr>
<tr><td><input type="text" name="type" placeholder="Gear/ Gearless"></td></tr>
<tr><td><input type="text" name="cc" placeholder="Engine Capacity"></td></tr>
<tr><td><input type="text" name="year" placeholder="Year of manufacture"></td></tr>
<tr><td><input type="text" name="milage" placeholder="Expected milage"></td></tr>
<tr><td><input type="text" name="price" placeholder="On Road Price"></td></tr>
<tr><td><input type="text" name="quantity" placeholder="Number of stocks imported"></td></tr>
<tr>
<td><input type="submit" value="Add to Stock"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</body>
</html>