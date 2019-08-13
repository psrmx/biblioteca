package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


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
    public void ShouldPrintAListOfAllBooks() throws Exception {
        // arrange
        ListOfBooks books = new ListOfBooks();
        books.addBook(new Book("A", "Tom", "1999"));
        books.addBook(new Book("B", "Patti", "1988"));
        books.addBook(new Book("C", "Marta", "2001"));
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBooks();
        // assert
        String expectedOut = "A | Tom | 1999" + "\n" + "B | Patti | 1988" + "\n" + "C | Marta | 2001" + "\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void ShouldPrintAnEmptyListOfBooks() throws Exception {
        // arrange
        ListOfBooks books = new ListOfBooks();
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBooks();
        // assert
        String expectedOut = "";
        assertThat(contentOut.toString(), is(expectedOut));
    }
}
