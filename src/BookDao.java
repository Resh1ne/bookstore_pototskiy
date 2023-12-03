import java.util.List;

public interface BookDao {
    Book create(Book book);
    //INSERT INTO books (поле1, поле2) VALUES (?, ?);

    Book readById(Long id);

    List<Book> readAll();

    Book update(Book book);
    //UPDATE books SET  поле1 = ?, поле2 = ? WHERE id = ?

    boolean delete(Long id);
    //DELETE FROM books WHERE id = ?;

    Book findByIsbn(String isbn);

    List<Book> findByAuthor(String author);

    long countAll();
}
