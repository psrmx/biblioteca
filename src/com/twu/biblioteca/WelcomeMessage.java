package com.twu.biblioteca;

public class WelcomeMessage {

    private String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public WelcomeMessage() {

        this.message = message;
    }

    @Override
    public String toString(){

        return String.format(message);
    }

}
