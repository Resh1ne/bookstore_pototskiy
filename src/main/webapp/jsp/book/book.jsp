<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${book.title} - Book Details</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../navbar.jsp" />

    <div class="container">
        <div class="book-details">
            <h1>${book.title}</h1>
            <p class="book-meta">${date}</p>

            <div class="book-info">
                <p><strong>ID:</strong> ${book.id}</p>
                <p><strong>Title:</strong> ${book.title}</p>
                <p><strong>ISBN:</strong> ${book.isbn}</p>
                <p><strong>Author:</strong> ${book.author}</p>
                <p><strong>Pages:</strong> ${book.pages}</p>
                <p><strong>Year:</strong> ${book.publicationYear}</p>
                <p><strong>Price:</strong> $${book.price}</p>
                <p><strong>Language:</strong> ${book.language}</p>
                <p><strong>Genre:</strong> ${book.genre}</p>
            </div>

            <a href="controller?command=edit_book_form&id=${book.id}" class="btn btn-edit">Edit Book</a>
        </div>
    </div>
</body>
</html>