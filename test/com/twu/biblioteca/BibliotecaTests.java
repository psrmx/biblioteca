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
        assertThat(message.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void ShouldCreateABookInstance() {
        // arrange
        Book b = new Book("B","Tom","1999");

        // assert
        assertThat(b.getTitle(), is("B"));
        assertThat(b.getAuthor(), is("Tom"));
        assertThat(b.getYear(), is("1999"));
    }

    @Test
    public void ShouldDisplayTheCorrectBookInformation() {
        // arrange
        Book b = new Book("B","Tom","1999");

        // assert
        assertThat(b.toString(), is("B | Tom | 1999"));

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
