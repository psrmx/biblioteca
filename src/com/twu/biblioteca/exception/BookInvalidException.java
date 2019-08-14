package com.twu.biblioteca.exception;

public class BookInvalidException extends Exception {
    private final static String message = "Sorry, that book is not available";

    public BookInvalidException() {
        super(message);
    }
}
