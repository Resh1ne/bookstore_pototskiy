<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Book</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="form-container">
            <h1>Edit Book</h1>

            <form method="post" action="controller">
                <input name="command" type="hidden" value="edit_book" />
                <input name="id" type="hidden" value="${book.id}" />

                <div class="form-group">
                    <label for="title">Title:</label>
                    <input id="title" name="title" type="text" required value="${book.title}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input id="isbn" name="isbn" type="text" required value="${book.isbn}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="author">Author:</label>
                    <input id="author" name="author" type="text" value="${book.author}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="pages">Pages:</label>
                    <input id="pages" name="pages" type="number" required value="${book.pages}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="publicationYear">Publication Year:</label>
                    <input id="publicationYear" name="publicationYear" required type="number" value="${book.publicationYear}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input id="price" name="price" type="number" required value="${book.price}" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="language">Language:</label>
                    <select id="language" name="language" class="form-control">
                        <option value="ENGLISH" ${book.language=='ENGLISH' ? 'selected' : ''}>English</option>
                        <option value="CHINESE" ${book.language=='CHINESE' ? 'selected' : ''}>Chinese</option>
                        <option value="SPANISH" ${book.language=='SPANISH' ? 'selected' : ''}>Spanish</option>
                        <option value="ARABIC" ${book.language=='ARABIC' ? 'selected' : ''}>Arabic</option>
                        <option value="FRENCH" ${book.language=='FRENCH' ? 'selected' : ''}>French</option>
                        <option value="RUSSIAN" ${book.language=='RUSSIAN' ? 'selected' : ''}>Russian</option>
                        <option value="PORTUGUESE" ${book.language=='PORTUGUESE' ? 'selected' : ''}>Portuguese</option>
                        <option value="JAPANESE" ${book.language=='JAPANESE' ? 'selected' : ''}>Japanese</option>
                        <option value="GERMAN" ${book.language=='GERMAN' ? 'selected' : ''}>German</option>
                        <option value="KOREAN" ${book.language=='KOREAN' ? 'selected' : ''}>Korean</option>
                        <option value="TURKISH" ${book.language=='TURKISH' ? 'selected' : ''}>Turkish</option>
                        <option value="ITALIAN" ${book.language=='ITALIAN' ? 'selected' : ''}>Italian</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="genre">Genre:</label>
                    <select id="genre" name="genre" class="form-control">
                        <option value="REALISM" ${book.genre=='REALISM' ? 'selected' : ''}>Realism</option>
                        <option value="SCIENCE_FICTION" ${book.genre=='SCIENCE_FICTION' ? 'selected' : ''}>Science Fiction</option>
                        <option value="THRILLER" ${book.genre=='THRILLER' ? 'selected' : ''}>Thriller</option>
                        <option value="ROMANCE" ${book.genre=='ROMANCE' ? 'selected' : ''}>Romance</option>
                        <option value="ADVENTURE" ${book.genre=='ADVENTURE' ? 'selected' : ''}>Adventure</option>
                        <option value="HORROR" ${book.genre=='HORROR' ? 'selected' : ''}>Horror</option>
                        <option value="HISTORICAL_FICTION" ${book.genre=='HISTORICAL_FICTION' ? 'selected' : ''}>Historical Fiction</option>
                        <option value="DRAMA" ${book.genre=='DRAMA' ? 'selected' : ''}>Drama</option>
                        <option value="COMEDY" ${book.genre=='COMEDY' ? 'selected' : ''}>Comedy</option>
                        <option value="FANTASY" ${book.genre=='FANTASY' ? 'selected' : ''}>Fantasy</option>
                        <option value="NON_FICTION" ${book.genre=='NON_FICTION' ? 'selected' : ''}>Non-Fiction</option>
                    </select>
                </div>

                <input type="submit" value="Update Book" class="btn" />
            </form>
        </div>
    </div>
</body>
</html>