package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BibliotecaTests {
    // arrange objects
    private WelcomeMessage message = new WelcomeMessage();
    private Book b = new Book("B", "Tom", "1999");
    private Movie m = new Movie("Kill Bill", "Tarantino", "2002", "8");
    private Movie m_bis = new Movie("Shawshank redemption", "Doe", "1995", "unrated");
    private User user = new User("111-1111", "123password");

    @Test
    public void shouldPrintWelcomeMessageWhenInitialized() {
        assertThat(message.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void ShouldCreateABookInstance() {
        assertThat(b.getTitle(), is("B"));
        assertThat(b.getAuthor(), is("Tom"));
        assertThat(b.getYear(), is("1999"));
    }

    @Test
    public void ShouldPrintTheCorrectBookInformation() {
        assertThat(b.toString(), is("B | Tom | 1999"));
    }

    @Test
    public void ShouldCreateAMovieInstance() {
        assertThat(m.getTitle(), is("Kill Bill"));
        assertThat(m.getAuthor(), is("Tarantino"));
        assertThat(m.getYear(), is("2002"));
        assertThat(m.getRating(), is("8"));
        assertThat(m_bis.getRating(), is("unrated"));
    }

    @Test
    public void ShouldPrintTheCorrectMovieInformation() {
        assertThat(m.toString(), is("Kill Bill | Tarantino | 2002 | 8"));
        assertThat(m_bis.toString(), is("Shawshank redemption | Doe | 1995 | unrated"));
    }

    @Test
    public void ShouldSetUsernameToABiblioObjectWhenCheckout() {
        m_bis.setUsername(user.username);
        assertThat(m_bis.getUsername(), is("111-1111"));
    }
}