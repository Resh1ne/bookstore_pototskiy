package com.belhard.bookstore;

import java.util.List;

public interface BookDao {
    Book create(Book book);

    Book findById(Long id);

    List<Book> findAll();

    Book update(Book book);

    boolean delete(Long id);
    @SuppressWarnings("unused")
    Book findByIsbn(String isbn);
    @SuppressWarnings("unused")
    List<Book> findByAuthor(String author);

    long countAll();
}