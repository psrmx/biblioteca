package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTests {
    public ListOfBibliotecaObjects books = new ListOfBibliotecaObjects();

    @Test
    public void ShouldPrintOnlyAvailableBooks() {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBibObj(false);
        // assert
        String expectedOut = "\tA | Tom | 1999\n\tB | Patti | 1988\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void ShouldChangeAvailabilityOfCheckedoutBook() {
        books.checkoutBibObj('A');
        assertThat(books.outBooks.contains('A'), is(false));
    }

    @Test
    public void ShouldReturnABookWhenValidOptionSelected() {
        books.checkinBibObj('A');
        assertThat(books.inBooks.contains('A'), is(true));
    }
}
