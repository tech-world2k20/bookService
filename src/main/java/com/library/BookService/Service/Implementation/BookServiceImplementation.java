package com.library.BookService.Service.Implementation;

import com.library.BookService.Dto.BookDto;
import com.library.BookService.Entity.Book;
import com.library.BookService.Exception.BookAlreadyExists;
import com.library.BookService.Exception.BookNotFoundException;
import com.library.BookService.Mapper.ModelMapper;
import com.library.BookService.Repo.BookRepo;
import com.library.BookService.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepo bookRepo;

    ModelMapper mapperClass = new ModelMapper();

    @Override
    public BookDto createBook(BookDto bookDto) {
        Optional<Book> existingBook = bookRepo.findByTitle(bookDto.getTitle());
        if(existingBook.isPresent()){
            throw new BookAlreadyExists("Book with Title Name : "+bookDto.getTitle()+" already exists..");
        }
        Book bookEntity =  mapperClass.mapToEntity(bookDto);
        Book savedEntity = bookRepo.save(bookEntity);
        return mapperClass.mapToDto(savedEntity);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map( (book) -> mapperClass.mapToDto(book) )
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book getBook = bookRepo.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book","Id",id)
        );
        return mapperClass.mapToDto(getBook);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookRepo.findById(bookDto.getId()).orElseThrow(
                () -> new BookNotFoundException("BOOK","ID", bookDto.getId())
        );
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        book.setPublicationDate(bookDto.getPublicationDate());
        book.setTotalPages(bookDto.getTotalPages());
        book.setAvailable(bookDto.isAvailable());
        Book updatedBook = bookRepo.save(book);
        return mapperClass.mapToDto(updatedBook);
    }

    @Override
    public void deleteBookById(Long id){
        Book existingBook = bookRepo.findById(id).orElseThrow(
                () -> new BookNotFoundException("BOOK","ID",id)
        );
        bookRepo.deleteById(id);
    }
}
