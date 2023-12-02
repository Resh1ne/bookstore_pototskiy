import java.time.LocalDate;
import java.util.Objects;

public class Book {
    Long id;
    String isbn;
    String author;
    String title;
    Integer pages;
    String publicationDate;
    String genre;
    String language;
    Double price;

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

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
}
