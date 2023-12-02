import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String PASSWORD = "root";
    public static final String USER = "postgres";
    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/bookstore_pototskiy";

    public static void main(String[] args){
        List<Book> books = getAllBooks();
        for(Book book : books){
            System.out.println(book.toString());
        }

        System.out.println("--------------------------------------");
        Book book =  getBook(20);
        System.out.println(book);
    }

    private static List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books");
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getString("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return books;
    }

    private static Book getBook(long id){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement("SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getString("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                return book;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
