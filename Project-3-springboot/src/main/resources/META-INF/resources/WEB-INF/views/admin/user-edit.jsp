<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>

<form action="${pageContext.request.contextPath}/admin/user/edit"
      method="post">

    <input type="hidden"
           name="id"
           value="${user.id}">

    <label>Username:</label>
    <input type="text"
           name="username"
           value="${user.username}"
           required>

    <br><br>

    <label>Password:</label>
    <input type="text"
           name="password"
           value="${user.password}"
           required>

    <br><br>

    <label>Email:</label>
    <input type="email"
           name="email"
           value="${user.email}"
           required>

    <br><br>

    <button type="submit">Save</button>

</form>

<br>

<a href="${pageContext.request.contextPath}/admin/user">
    Back
</a>

</body>
</html>