<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
</head>
<body>

<h2>User Management</h2>

<form action="${pageContext.request.contextPath}/admin/user/add"
      method="post">

    <input type="text"
           name="username"
           placeholder="Username"
           required>

    <input type="password"
           name="password"
           placeholder="Password"
           required>

    <input type="email"
           name="email"
           placeholder="Email"
           required>

    <button type="submit">Add</button>

</form>

<br>

<form action="${pageContext.request.contextPath}/admin/user"
      method="get">

    <input type="text"
           name="keyword"
           value="${keyword}"
           placeholder="Search username">

    <button type="submit">Search</button>

</form>

<br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Action</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/user/edit?id=${user.id}">
                    Edit
                </a>

                |

                <a href="${pageContext.request.contextPath}/admin/user/delete?id=${user.id}"
                   onclick="return confirm('Are you sure you want to delete this user?')">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>