<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New User</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="form-container">
            <h1>Register New User</h1>

            <form method="post" action="controller" class="user-form">
                <input name="command" type="hidden" value="create_user" />

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input id="email" name="email" type="email" required class="form-control" />
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input id="password" name="password" type="password" required class="form-control" />
                </div>

                <input type="submit" value="Create User" class="btn" />
            </form>
        </div>
    </div>
</body>
</html>