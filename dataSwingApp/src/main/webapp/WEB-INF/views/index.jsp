<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div style="margin-bottom: 10px;">
		<a href="create"
			style="padding: 8px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px;">Create
			User</a>
	</div>
	<h1>User List</h1>
	<table border="1" style="border-collapse: collapse; width: 100%;">
		<thead>
			<tr style="background-color: #f2f2f2;">
				<th style="padding: 8px; text-align: left;">ID</th>
				<th style="padding: 8px; text-align: left;">Name</th>
				<th style="padding: 8px; text-align: left;">Role</th>
				<th style="padding: 8px; text-align: left;">Email</th>
				<th style="padding: 8px; text-align: left;">Password</th>
				<th style="padding: 8px; text-align: left;">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="users" items="${users}">
				<tr style="background-color: #fff;">
					<td style="padding: 8px; text-align: left;">${users.getId()}</td>
					<td style="padding: 8px; text-align: left;">${users.getName()}</td>
					<td style="padding: 8px; text-align: left;">${users.getRole()}</td>
					<td style="padding: 8px; text-align: left;">${users.getEmail()}</td>
					<td style="padding: 8px; text-align: left;">${users.getPassword()}</td>
					<td style="padding: 8px; text-align: left;"><a
						href="editUser?id=${users.getId()}">Edit</a> | <!-- Edit button -->
						<a href="deleteUser?id=${users.getId()}">Delete</a> <!-- Delete button -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
