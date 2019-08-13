package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class ListOfBooks {

    public List<Book> allBooks = new ArrayList<Book>();

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
