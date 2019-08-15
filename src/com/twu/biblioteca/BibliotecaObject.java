package com.twu.biblioteca;

public class BibliotecaObject {
    private String title;
    private String author;
    private String year;
    private String rating;
    private String username = "";

    public BibliotecaObject(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public BibliotecaObject(String title, String author, String year, String rating) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getYear() { return this.year; }

    public String getRating() { return this.rating; }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString(){
        return String.format(this.getTitle() + " | " + this.getAuthor() + " | " + this.getYear());
    }
}
