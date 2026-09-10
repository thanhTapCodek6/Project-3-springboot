<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Category</title>
</head>
<body>

<h2>Edit Category</h2>

<form action="${pageContext.request.contextPath}/admin/category/edit" method="post">

    <input type="hidden" name="id" value="${category.id}">

    <label>Name:</label>
    <input type="text" name="name" value="${category.name}" required>

    <button type="submit">Save</button>

</form>

</body>
</html>