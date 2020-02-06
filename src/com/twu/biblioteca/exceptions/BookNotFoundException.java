package com.twu.biblioteca;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
