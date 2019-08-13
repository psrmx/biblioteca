package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private Boolean available = true;

    public Book(String title, String author, String year) {
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

    public Boolean isAvailable(){
        return this.available;
    }

    public void setAvailable(Boolean av) {
        this.available = av;
    }

    @Override
    public String toString(){
        return String.format(title + " | " + author + " | " + year);
    }
}
