package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.mockito.Matchers.same;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;


public class BibliotecaTests {
    @Test
    public void shouldPrintWelcomeMessageWhenInitialized() {
        // arrange
        WelcomeMessage message = new WelcomeMessage();

        // assert
        assertThat(message.getMessage(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldPrintListOfBooks() {
        // arrange
        ListOfBooks books = new ListOfBooks();
        String[] ourBooks = new String[]{"A", "B", "C"};

        // assert
        assertThat(books.getListOfBooks(), is(ourBooks));
    }
}
