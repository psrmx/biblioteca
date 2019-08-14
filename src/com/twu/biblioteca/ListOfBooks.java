package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;


public class ListOfBooks {

    private List<Book> allBooks;

    public ListOfBooks() {
        Book[] allBooks = {
            new Book("A", "Tom", "1999", true),
            new Book("B", "Patti", "1988", true),
            new Book("C", "Marta", "2001", false)
        };
        this.allBooks = Arrays.asList(allBooks);
    }

    public ListOfBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

        public void addBook(Book book){
        allBooks.add(book);
    }

    public void printBooks(){
        allBooks.forEach(b -> {
            if (b.isAvailable()) {
                System.out.println(b);
            }
        });
    }
}
