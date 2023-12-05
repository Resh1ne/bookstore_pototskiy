package com.belhard.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookDaoRealization implements BookDao {
    private static final String CREATION_QUERY = "INSERT INTO books (author, isbn, title, pages, publication_date, genre, \"language\", price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PASSWORD = "root";
    private static final String USER = "postgres";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bookstore_pototskiy";
    private static final String READ_ALL_QUERY = "SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books";
    private static final String READ_BY_ID_QUERY = "SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books WHERE id = ?";
    private static final String READ_BY_ISBN = "SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books WHERE isbn = ?";
    private static final String UPDATE_QUERY = "UPDATE books SET  author = ?, isbn = ?, title = ?, pages = ?, publication_date = ?, genre = ?, \"language\" = ?, price = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM books WHERE id = ?";
    private static final String FIND_BY_AUTHOR_QUERY = "SELECT id, author, isbn, title, pages, publication_date, genre, \"language\", price FROM books WHERE author = ?";

    @Override
    public Book create(Book book) {
        if (checkAvailability(book)) {
            throw new RuntimeException("This object already exists");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(CREATION_QUERY);
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getIsbn());
            statement.setString(3, book.getTitle());
            setNullInt(4, book.getPages(), statement);
            statement.setDate(5, book.getPublicationDate());
            statement.setString(6, book.getGenre());
            statement.setString(7, book.getLanguage());
            setNullDouble(8, book.getPrice(), statement);
            statement.executeUpdate();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setNullInt(int index, Integer value, PreparedStatement statement) throws SQLException {
        if (value == null) {
            statement.setNull(index, Types.INTEGER);
        } else {
            statement.setInt(index, value);
        }
    }

    private void setNullDouble(int index, Double value, PreparedStatement statement) throws SQLException {
        if (value == null) {
            statement.setNull(index, Types.DOUBLE);
        } else {
            statement.setDouble(index, value);
        }
    }

    private boolean checkAvailability(Book book) {
        List<Book> allBooks = readAll();
        return allBooks.contains(book);
    }

    @Override
    public List<Book> readAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ALL_QUERY);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book readById(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(READ_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book findByIsbn(String isbn) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(READ_BY_ISBN);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_AUTHOR_QUERY);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setPublicationDate(resultSet.getDate("publication_date"));
                book.setGenre(resultSet.getString("genre"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book update(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getIsbn());
            statement.setString(3, book.getTitle());
            setNullInt(4, book.getPages(), statement);
            statement.setDate(5, book.getPublicationDate());
            statement.setString(6, book.getGenre());
            statement.setString(7, book.getLanguage());
            setNullDouble(8, book.getPrice(), statement);
            statement.setLong(9, book.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return book;
            } else {
                throw new RuntimeException("Failed to update book. No rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countAll() {
        return readAll().size();
    }
}
