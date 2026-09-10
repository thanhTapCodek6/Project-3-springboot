<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>
</head>
<body>

	<h2>Category Management</h2>

	<form action="${pageContext.request.contextPath}/admin/category/add"
		method="post">

		<input type="text" name="name" placeholder="Category name" required>

		<button type="submit">Add</button>


	</form>

	<form action="${pageContext.request.contextPath}/admin/category"
		method="get">

		<input type="text" name="keyword" value="${keyword}"
			placeholder="Search category">

		<button type="submit">Search</button>
	</form>

	<br>

	<br>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Action</th>
		</tr>

		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td><a
					href="${pageContext.request.contextPath}/admin/category/edit?id=${category.id}">
						Edit </a> | <a
					href="${pageContext.request.contextPath}/admin/category/delete?id=${category.id}"
					onclick="return confirm('Are you sure you want to delete this category?')">
						Delete </a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>