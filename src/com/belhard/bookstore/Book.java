package com.belhard.bookstore;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private Long id;
    private String isbn;
    private String author;
    private String title;
    private Integer pages;
    private Integer publicationYear;
    private GenresOfTheBook genre;
    private LanguagesOfTheBook language;
    private BigDecimal price;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Book book = (Book) o;
        return Objects.equals(author, book.author) //
                && Objects.equals(isbn, book.isbn) //
                && Objects.equals(title, book.title) //
                && Objects.equals(id, book.id) //
                && Objects.equals(pages, book.pages) //
                && Objects.equals(publicationYear, book.publicationYear) //
                && Objects.equals(genre, book.genre) //
                && Objects.equals(language, book.language) //
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn, title, id, pages, publicationYear, genre, language, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", publicationDate='" + publicationYear + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }

    @SuppressWarnings("unused")
    public String shortToString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate='" + publicationYear + '\'' +
                '}';
    }
}
