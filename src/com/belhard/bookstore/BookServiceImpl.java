package com.belhard.bookstore;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public BookDto create(BookDto dto) {
        return null;
    }

    @Override
    public List<BookDto> getAll() {
        return bookDao.findAll()
                .stream()
                .map(this::toBookDto)
                .toList();
    }

    @Override
    public BookDto getById(long id) {
        Book bookEntity = bookDao.findById(id);
        if (bookEntity == null) {
            throw new RuntimeException("No book with id: " + id);
        }
        return toBookDto(bookEntity);
    }

    @Override
    public BookDto update(BookDto dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    private BookDto toBookDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setAuthor(book.getAuthor());
        bookDto.setId(book.getId());
        bookDto.setGenre(book.getGenre());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setPages(book.getPages());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublicationYear(book.getPublicationYear());
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }
}
