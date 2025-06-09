<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Users</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <h1>User Management</h1>

        <div class="action-bar">
            <a href="controller?command=create_user_form" class="btn">Create New User</a>
        </div>

        <table class="users-table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${user.id}</td>
                        <td>
                            <a href="controller?command=user&id=${user.id}">${user.email}</a>
                        </td>
                        <td>${user.firstName} ${user.lastName}</td>
                        <td>
                        <span class="role-badge role-${user.role.name().toLowerCase()}">
                                ${user.role}
                            </span>
                        </td>
                        <td>
                            <a href="controller?command=edit_user_form&id=${user.id}" class="btn btn-edit">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>