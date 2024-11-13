package com.library.BookService.Controller;

import com.library.BookService.Dto.BookDto;
import com.library.BookService.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id){
        BookDto getBook = bookService.getBookById(id);
        return new ResponseEntity<>(getBook,HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> getBooks = bookService.getAllBooks();
        return new ResponseEntity<>(getBooks,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        BookDto updatedBook = bookService.updateBook(bookDto);
        return new ResponseEntity<>(updatedBook,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book with Id "+ id +" Successfully deleted",HttpStatus.OK);
    }
//
}
