package com.twu.biblioteca;

public class Movie extends BibliotecaObject {

    public Movie(String title, String author, String year, String rating) {
        super(title, author, year, rating);
    }

    @Override
    public String toString(){
        return String.format(this.getTitle() + " | " + this.getAuthor() + " | " + this.getYear() + " | " + this.getRating());
    }

}
