package com.library.BookService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String title;
    @Column(nullable = false,length = 200)
    private String author;
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String isbn;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private LocalDate publicationDate;
    @Column(nullable = false)
    private int totalPages;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private boolean available;


}
