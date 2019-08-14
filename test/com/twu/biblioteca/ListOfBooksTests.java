package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTests {
    public ListOfBooks books = new ListOfBooks();

    @Test
    public void ShouldPrintOnlyAvailableBooks() {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBooks(false);
        // assert
        String expectedOut = "\tA | Tom | 1999\n\tB | Patti | 1988\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void ShouldChangeAvailabilityOfCheckedoutBook() {
        books.checkoutBook('A');
        assertThat(books.outBooks.contains('A'), is(false));
    }

    @Test
    public void ShouldReturnABookWhenValidOptionSelected() {
        books.checkinBook('A');
        assertThat(books.inBooks.contains('A'), is(true));
    }
}
