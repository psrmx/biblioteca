package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTests {
    public Book a = new Book("A", "Tom", "1999");
    public Book b = new Book("B", "Patti", "1988");
    public Book c = new Book("C", "Marta", "2001");

    @Test
    public void ShouldPrintAListOfAllBooks() throws Exception {
        // arrange
        ListOfBooks books = new ListOfBooks();
        books.addBook(a);
        books.addBook(b);
        books.addBook(c);
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

    @Test
    public void ShouldPrintOnlyAvailableBooks() {
        // arrange
        ListOfBooks books = new ListOfBooks();
        books.addBook(a);
        books.addBook(b);
        c.setAvailable(false);
        books.addBook(c);
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBooks();
        // assert
        String expectedOut = "A | Tom | 1999" + "\n" + "B | Patti | 1988" + "\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }
}
