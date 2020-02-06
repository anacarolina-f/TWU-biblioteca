package com.twu.biblioteca.exceptions;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
