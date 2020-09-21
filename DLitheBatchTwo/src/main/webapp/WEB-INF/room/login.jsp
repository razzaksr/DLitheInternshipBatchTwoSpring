<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
</head>
<body>
${msg}
<form action="check" method="post">
<table>
<tr><td><input type="text" placeholder="USername" name="user"></td></tr>
<tr><td><input type="password" placeholder="PASSWORD" name="pass"></td></tr>
<tr><td><input type="submit" value="Login"></td>
<td><input type="reset" value="Clear"></td></tr>
</table>
</form>
</body>
</html>