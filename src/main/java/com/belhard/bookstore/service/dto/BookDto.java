package com.belhard.bookstore.service.dto;

import com.belhard.bookstore.data.enums.GenresOfTheBook;
import com.belhard.bookstore.data.enums.LanguagesOfTheBook;

import java.math.BigDecimal;
import java.util.Objects;

public class BookDto {
    private Long id;
    private String isbn;
    private String author;
    private String title;
    private Integer pages;
    private Integer publicationYear;
    private GenresOfTheBook genre;
    private LanguagesOfTheBook language;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public GenresOfTheBook getGenre() {
        return genre;
    }

    public void setGenre(GenresOfTheBook genre) {
        this.genre = genre;
    }

    public LanguagesOfTheBook getLanguage() {
        return language;
    }

    public void setLanguage(LanguagesOfTheBook language) {
        this.language = language;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) && Objects.equals(isbn, bookDto.isbn) && Objects.equals(author, bookDto.author) && Objects.equals(title, bookDto.title) && Objects.equals(pages, bookDto.pages) && Objects.equals(publicationYear, bookDto.publicationYear) && genre == bookDto.genre && language == bookDto.language && Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, author, title, pages, publicationYear, genre, language, price);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", publicationYear=" + publicationYear +
                ", genre=" + genre +
                ", language=" + language +
                ", price=" + price +
                '}';
    }
}
