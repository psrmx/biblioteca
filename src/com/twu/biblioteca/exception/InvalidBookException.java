package com.twu.biblioteca.exception;

public class InvalidBookException extends Exception {
    private final static String message = "Sorry, that book is not available";

    public InvalidBookException() {
        super(message);
    }
}
