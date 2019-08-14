package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTests {
    MainMenu menu = new MainMenu();

    @Test
    public void shouldTakeCorrectUserInput() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(1, is(menu.getInput()));
    }

    @Test
    public void shouldPrintMenuOptions() {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        menu.printMenu();
        // assert
        String expectedOut = "Menu of options: " + "\n" + "(1) List of books" + "\n" + "(2) Quit biblioteca"  + "\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    @Test
    public void shouldQuitBibliotecaWhenTwoIsSelected() {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.chooseAction();

        String expectedOut = "Menu of options: \n(1) List of books\n(2) Quit biblioteca\nGoodbye user!\n";
        assertThat(contentOut.toString(), is(expectedOut));
    }

    // TODO: test exception/invalid inputs
    // TODO: test runMenu method
}
