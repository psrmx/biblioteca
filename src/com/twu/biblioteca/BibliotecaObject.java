package com.twu.biblioteca;

public class BibliotecaObject {
    private String title;
    private String author;
    private String year;

    public BibliotecaObject(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getYear(){
        return this.year;
    }

    @Override
    public String toString(){
        return String.format(title + " | " + author + " | " + year);
    }
}
