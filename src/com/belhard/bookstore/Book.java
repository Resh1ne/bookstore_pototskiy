package com.belhard.bookstore;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Book {
    private Long id;
    private String isbn;
    private String author;
    private String title;
    private Integer pages;
    private Date publicationDate;
    private String genre;
    private String language;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
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
                && Objects.equals(publicationDate, book.publicationDate) //
                && Objects.equals(genre, book.genre) //
                && Objects.equals(language, book.language) //
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn, title, id, pages, publicationDate, genre, language, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", publicationDate='" + publicationDate + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }

    public String shortToString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }
}
