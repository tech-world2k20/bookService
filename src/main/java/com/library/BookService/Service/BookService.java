package com.library.BookService.Service;

import com.library.BookService.Dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto book);
    List<BookDto> getBooks();
    BookDto getBookById(Long id);
    BookDto updateBook(BookDto book);
    void deleteBookById(Long id);
    Page<BookDto> getAllBooks(Pageable pageable);
}
