package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTests {
    private ListOfBooks books = new ListOfBooks();

    @Test
    public void ShouldPrintAnEmptyListOfBooksWhenInitializedWithNull() throws Exception {
        // arrange
        ListOfBooks books = new ListOfBooks(Collections.emptyList());
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
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        books.printBooks();
        // assert
        String expectedOut = "A | Tom | 1999" + "\n" + "B | Patti | 1988" + "\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }
}
