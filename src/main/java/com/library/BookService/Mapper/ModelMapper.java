package com.library.BookService.Mapper;

import com.library.BookService.Dto.BookDto;
import com.library.BookService.Entity.Book;

public class ModelMapper {
    public static Book mapToEntity(BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        book.setPublicationDate(bookDto.getPublicationDate());
        book.setTotalPages(bookDto.getTotalPages());
        book.setAvailable(bookDto.isAvailable());
        return book;
    }

    public static BookDto mapToDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setGenre(book.getGenre());
        bookDto.setTitle(book.getTitle());
        bookDto.setPublisher(book.getPublisher());
        bookDto.setPublicationDate(book.getPublicationDate());
        bookDto.setTotalPages(book.getTotalPages());
        bookDto.setAvailable(book.isAvailable());
        return bookDto;
    }
}
