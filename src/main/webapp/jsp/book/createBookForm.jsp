<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Book</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="form-container">
            <h1>Register New Book</h1>

            <form method="post" action="controller">
                <input name="command" type="hidden" value="create_book" />

                <div class="form-group">
                    <label for="title">Title:</label>
                    <input id="title" name="title" type="text" required class="form-control" />
                </div>

                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input id="isbn" name="isbn" type="text" required class="form-control" />
                </div>

                <div class="form-group">
                    <label for="languages">Language:</label>
                    <select id="languages" name="language" class="form-control">
                        <option value="ENGLISH">English</option>
                        <option value="CHINESE">Chinese</option>
                        <option value="SPANISH">Spanish</option>
                        <option value="ARABIC">Arabic</option>
                        <option value="FRENCH">French</option>
                        <option value="RUSSIAN">Russian</option>
                        <option value="PORTUGUESE">Portuguese</option>
                        <option value="JAPANESE">Japanese</option>
                        <option value="GERMAN">German</option>
                        <option value="KOREAN">Korean</option>
                        <option value="TURKISH">Turkish</option>
                        <option value="ITALIAN">Italian</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="genres">Genre:</label>
                    <select id="genres" name="genre" class="form-control">
                        <option value="REALISM">Realism</option>
                        <option value="SCIENCE_FICTION">Science Fiction</option>
                        <option value="THRILLER">Thriller</option>
                        <option value="ROMANCE">Romance</option>
                        <option value="ADVENTURE">Adventure</option>
                        <option value="HORROR">Horror</option>
                        <option value="HISTORICAL_FICTION">Historical Fiction</option>
                        <option value="DRAMA">Drama</option>
                        <option value="COMEDY">Comedy</option>
                        <option value="FANTASY">Fantasy</option>
                        <option value="NON_FICTION">Non-Fiction</option>
                    </select>
                </div>

                <input type="submit" value="Create Book" class="btn" />
            </form>
        </div>
    </div>
</body>
</html>