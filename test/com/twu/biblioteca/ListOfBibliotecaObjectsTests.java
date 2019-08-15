package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfBibliotecaObjectsTests {
    public ListOfBibliotecaObjects books = new ListOfBibliotecaObjects("book");
    public ListOfBibliotecaObjects movies = new ListOfBibliotecaObjects("movie");

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
    public void ShouldAddABookToCheckedOutObjWhenCorrectBookTitleEntered() {
        books.checkoutBibObj("A");
        assertThat(books.outObjects.size(), is(2));
    }

    @Test
    public void ShouldAddABookToCheckedInBooksWhenCorrectBookTitleEntered() {
        books.checkinBibObj("C");
        assertThat(books.inObjects.size(), is(3));
    }

    @Test
    public void ShouldAddAMovieToCheckedOutObjWhenCorrectMovieTitleEntered() {
        movies.checkoutBibObj("Kill Bill");
        assertThat(movies.inObjects.size(), is(1));
    }

    @Test
    public void ShouldNotAddAMovieToCheckedOutObjWhenIncorrectMovieTitleEntered() {
        movies.checkinBibObj("Movie That's Not in The Lib");
        assertThat(movies.inObjects.size(), is(2));
    }

    @Test
    public void ShouldCheckInAMovieToCheckedInObjWhenCorrectMovieTitleEntered() {
        BibliotecaObject starWars = new Movie("Star Wars", "Lucas", "2010", "5");
        movies.checkinBibObj("Star Wars");
        assertThat(movies.inObjects.size(), is(3));
    }

//    @Test
//    public void ShouldAddMovieToCheckedInBooksWhenCorrectBookTitleEntered() {
//        movies.checkinBibObj("C");
//        assertThat(movies.inObjects.size(), is(3));
//    }
}
