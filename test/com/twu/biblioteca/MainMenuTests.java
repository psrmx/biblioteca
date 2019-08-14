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
    private String expectedMenu = "Menu of options: \n(1) List of books\n(2) Quit biblioteca\n(3) Checkout a book\n(4) Return a book\n";

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
    public void shouldQuitBibliotecaWhenTwoIsSelected() throws BookInvalidException {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        // action
        InputStream in = providedInput("2");
        System.setIn(in);
        menu.chooseAction();
        // assert
        String expectedOut = expectedMenu + "Goodbye user!\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldDoSuccessfulCheckoutWhenValidBook() throws BookInvalidException {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        // action
        InputStream in = providedInput("1");
        System.setIn(in);
        menu.chooseBookToCheckout();
        // assert
        String expectedOut = "Which book do you want to checkout?\n\t1. A | Tom | 1999\n\t2. B | Patti | 1988\n" + "Thank you! Enjoy the book.\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldDoUnsuccessfulCheckoutWhenInvalidBook() {
        Boolean thrown = false;
        try {
            InputStream in = providedInput("k");
            System.setIn(in);
            menu.chooseBookToCheckout();
        } catch (BookInvalidException e) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }


    // TODO: test exception/invalid inputs
    // TODO: test runMenu method
}
