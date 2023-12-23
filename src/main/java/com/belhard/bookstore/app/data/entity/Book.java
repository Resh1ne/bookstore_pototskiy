package com.belhard.bookstore.app.data.entity;

import com.belhard.bookstore.app.data.entity.enums.GenresOfTheBook;
import com.belhard.bookstore.app.data.entity.enums.LanguagesOfTheBook;
import lombok.Data;

import java.math.BigDecimal;

@Data
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
}
