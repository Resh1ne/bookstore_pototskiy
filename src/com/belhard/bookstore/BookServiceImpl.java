package com.belhard.bookstore;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public BookDto create(BookDto dto) {
        Book book = toBookEntity(dto);
        Book bookCreated = bookDao.create(book);
        return toBookDto(bookCreated);
    }

    private Book toBookEntity(BookDto dto) {
        Book bookEntity = new Book();
        bookEntity.setAuthor(dto.getAuthor());
        bookEntity.setGenre(dto.getGenre());
        bookEntity.setIsbn(dto.getIsbn());
        bookEntity.setLanguage(dto.getLanguage());
        bookEntity.setPages(dto.getPages());
        bookEntity.setPrice(dto.getPrice());
        bookEntity.setPublicationYear(dto.getPublicationYear());
        bookEntity.setTitle(dto.getTitle());
        return bookEntity;
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
        Book book = toBookEntity(dto);
        book.setId(dto.getId());
        Book bookCreated = bookDao.update(book);
        return toBookDto(bookCreated);
    }

    @Override
    public void delete(long id) {
        Book book = bookDao.findById(id);
        if (book == null) {
            throw new RuntimeException("Book with id: " + id + " not found");
        }
        bookDao.delete(id);
    }

    private BookDto toBookDto(Book book) {
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
