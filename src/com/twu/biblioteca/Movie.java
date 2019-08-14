package com.twu.biblioteca;

public class Movie extends BibliotecaObject {
    private String rating;

    public Movie(String title, String author, String year, String rating) {
        super(title, author, year);
        this.rating = rating;
    }

    public String getRating() {
        return this.rating;
    }
}
