package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTests {

    @Test
    public void shouldTakeCorrectUserInput() {
        MainMenu menu = new MainMenu();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(2, is(menu.getInput()));
    }

    @Test
    public void shouldPrintMenuWhenOneIsSelected() {
        MainMenu menu = new MainMenu();
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        menu.setReadLine(1);
        menu.chooseAction();
        // assert
        String expectedOut = "Menu of options: " + "\n" + "(1) List of books" + "\n" + "(2) Quit biblioteca";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldQuitBibliotecaWhenTwoIsSelected() {
        MainMenu menu = new MainMenu();
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        menu.setReadLine(2);
        menu.chooseAction();

        String expectedOut = "Goodbye user!";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldCheckoutBookWhenThreeIsSelectedAndValidBook() {
        MainMenu menu = new MainMenu();
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        menu.setReadLine(3);
        menu.chooseAction();

        String expectedOut = "Thank you! Enjoy the book";
        assertThat(contentOut.toString(), is(expectedOut));
    }
    // TODO: test exception/invalid inputs
}
