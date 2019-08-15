package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTests {
    public ListOfBibliotecaObjects books = new ListOfBibliotecaObjects("Book");

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

    // we need to iterate through each object until we have found the proper value
    @Test
    public void ShouldAddABookToCheckedOutBooksWhenCorrectBookTitleEntered() {
        books.checkoutBibObj("A");
        assertThat(books.outObjects.size(), is(2));
    }

    @Test
    public void ShouldAddABookToCheckedInBooksWhenCorrectBookTitleEntered() {
        books.checkinBibObj("C");
        assertThat(books.inObjects.size(), is(3));
    }
}
