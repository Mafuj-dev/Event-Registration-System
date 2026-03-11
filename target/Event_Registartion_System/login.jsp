<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">


Email <br>
<input type="email" name="email"><br><br>

Password <br>
<input type="password" name="password"><br><br>

<button type="submit">Login</button>

</form>

<a href="${pageContext.request.contextPath}/register.jsp">Register Here</a>
</body>
</html>