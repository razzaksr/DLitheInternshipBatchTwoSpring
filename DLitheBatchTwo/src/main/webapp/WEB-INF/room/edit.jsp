<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an vehicle</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }
<%@ taglib prefix="dlithe" uri="http://www.springframework.org/tags/form" %>
<dlithe:errors path="vehicle.*"/>
<form action="change" method="post">
<table>
<tr><td><input type="text" name="stkid" value="${one.getStkid() }"></td></tr>
<tr><td><input type="text" name="model" value="${one.getModel() }"></td></tr>
<tr><td><input type="text" name="type" value="${one.getType() }"></td></tr>
<tr><td><input type="text" name="cc" value="${one.getCc() }"></td></tr>
<tr><td><input type="text" name="year" value="${one.getYear() }"></td></tr>
<tr><td><input type="text" name="milage" value="${one.getMilage() }"></td></tr>
<tr><td><input type="text" name="price" value="${one.getPrice() }"></td></tr>
<tr><td><input type="text" name="quantity" value="${one.getQuantity() }"></td></tr>
<tr>
<td><input type="submit" value="Update to Stock"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</body>
</html>