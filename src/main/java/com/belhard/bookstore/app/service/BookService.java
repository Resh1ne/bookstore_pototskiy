package com.belhard.bookstore.app.service;

import com.belhard.bookstore.app.service.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto create(BookDto dto);

    List<BookDto> getAll();

    BookDto getById(long id);

    BookDto update(BookDto dto);

    void delete(long id);
}
