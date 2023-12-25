<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1>All Users</h1>
    <table>
        <tr>
            <th>#</th>
            <th>Id</th>
            <th>Email</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${users}" var="user" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${user.id}</td>
                <td><a href="user?id=${user.id}">${user.email}</a></td>
                <td>
                    <form>
                        <input type="hidden" name="command" value="edit_user_form">
                        <input type="hidden" name="id" value="${uuser.id}">
                        <input type="submit" value="Edit">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>