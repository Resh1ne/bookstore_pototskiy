<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="form-container">
            <h1>Edit User</h1>

            <form method="post" action="controller" class="user-form">
                <input name="command" type="hidden" value="edit_user" />
                <input name="id" type="hidden" value="${requestScope.user.id}" />

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input id="email" name="email" type="email" required
                           value="${user.email}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input id="password" name="password" type="password" required
                           value="${user.password}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input id="firstName" name="firstName" type="text"
                           value="${user.firstName}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input id="lastName" name="lastName" type="text"
                           value="${user.lastName}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="age">Age:</label>
                    <input id="age" name="age" type="number" min="1"
                           value="${user.age}" class="form-control" />
                </div>

                <div class="form-group">
                    <label>Role:</label>
                    <div class="radio-group">
                        <label class="radio-label">
                            <input type="radio" name="role" value="CUSTOMER"
                                   ${user.role=='CUSTOMER' ? 'checked' : ''}> Customer
                        </label>
                        <label class="radio-label">
                            <input type="radio" name="role" value="MANAGER"
                                   ${user.role=='MANAGER' ? 'checked' : ''}> Manager
                        </label>
                        <label class="radio-label">
                            <input type="radio" name="role" value="ADMIN"
                                   ${user.role=='ADMIN' ? 'checked' : ''}> Admin
                        </label>
                    </div>
                </div>

                <input type="submit" value="Update User" class="btn" />
            </form>
        </div>
    </div>
</body>
</html>