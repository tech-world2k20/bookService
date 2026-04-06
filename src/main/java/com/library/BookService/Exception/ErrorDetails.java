package com.library.BookService.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private String errorCode;

    public ErrorDetails(LocalDateTime localDateTime, String message, String path, String errorCode) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }
}
