package com.library.BookService.Service;

import com.library.BookService.Dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto book);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    BookDto updateBook(BookDto book);
    void deleteBookById(Long id);
}
