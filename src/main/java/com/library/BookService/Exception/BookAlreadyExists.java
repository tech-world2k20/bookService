package com.library.BookService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BookAlreadyExists extends RuntimeException{
    private String message;

    public BookAlreadyExists(String message) {
        super(message);
    }
}
