package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
       WelcomeMessage message = new WelcomeMessage();
       System.out.println(message.getMessage());

       ListOfBooks books = new ListOfBooks();
       Arrays.stream(books.getListOfBooks()).forEach(System.out::println);
    }

}
