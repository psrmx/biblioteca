package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookInvalidException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTests {
    MainMenu menu = new MainMenu();
    private String expectedMenu =
            "Menu of options: \n" +
            "(1) List of books\n" +
            "(2) Checkout a book\n" +
            "(3) Return a book\n" +
            "(4) List of movies\n" +
            "(5) Checkout a movie\n" +
            "(6) Return a movie\n" +
            "(9) Quit Biblioteca\n";

    private InputStream providedInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void shouldTakeCorrectUserInput() {
        InputStream in = providedInput("1");
        System.setIn(in);

        assertThat(1, is(menu.getInput()));
    }

    @Test
    public void shouldPrintMenuOptions() {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        // action
        menu.printMenu();
        // assert
        String expectedOut = expectedMenu;
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldQuitBibliotecaWhenQuitOptionIsSelected() throws BookInvalidException {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        // action
        InputStream in = providedInput("9");
        System.setIn(in);
        menu.chooseAction();
        // assert
        String expectedOut = expectedMenu + "Goodbye user!\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }
    // TODO: test exception/invalid inputs
    // TODO: test runMenu method
}
