<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<h2>Create User</h2>
	<form action="createUser" method="post" modelAttribute="createRequest">
		<label for="name">Name:</label><br> <input type="text" id="name"
			name="name" required><br>
		<br> <label for="email">Email:</label><br> <input
			type="email" id="email" name="email" required><br>
		<br> <label for="password">Password:</label><br> <input
			type="password" id="password" name="password" required><br>
		<br> <label for="role">Role:</label><br> <select id="role"
			name="role" required>
			<option value="admin">Admin</option>
			<option value="user">User</option>
		</select><br>
		<br> <input type="submit" value="save">
	</form>
</body>
</html>