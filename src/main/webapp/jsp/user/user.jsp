<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="user-details">
            <h1>User Profile</h1>
            <p class="meta-info">${date}</p>

            <div class="user-info">
                <div class="info-row">
                    <span class="info-label">ID:</span>
                    <span class="info-value">${user.id}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">Email:</span>
                    <span class="info-value">${user.email}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">Password:</span>
                    <span class="info-value">${user.password}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">First Name:</span>
                    <span class="info-value">${user.firstName}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">Last Name:</span>
                    <span class="info-value">${user.lastName}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">Age:</span>
                    <span class="info-value">${user.age}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">Role:</span>
                    <span class="info-value role-badge role-${user.role.name().toLowerCase()}">
                        ${user.role}
                    </span>
                </div>
            </div>

            <a href="controller?command=edit_user_form&id=${user.id}" class="btn btn-edit">Edit Profile</a>
        </div>
    </div>
</body>
</html>