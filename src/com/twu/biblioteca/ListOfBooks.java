package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;


public class ListOfBooks {

    public List<Book> allBooks;

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

    public void addBook(Book book) {
        this.allBooks.add(book);
    }

    public void checkoutBook(Integer bookIndex) {
        bookIndex -= 1;
        this.allBooks.get(bookIndex).setAvailable(false);
        System.out.println("Thank you! Enjoy the book.");
    }

    public void returnBook(Integer bookIndex) {
        bookIndex -= 1;
        this.allBooks.get(bookIndex).setAvailable(true);
        System.out.println("Thank you for returning the book.");
    }

    public void printBooks(ListOfBooks books) {
        for (Integer i = 0; i < books.allBooks.size(); i++) {
            Book b = allBooks.get(i);
            System.out.println("\t" + j.toString() + ". " + b)
        }
    }

    public void filterBooks(boolean availability) {
        for (Integer i = 0; i < allBooks.size(); i++) {
            Book b = allBooks.get(i);
            Integer j = i + 1;
            if (b.isAvailable() == availability) {
                System.out.println("\t" + j.toString() + ". " + b);
            }
        }
    }
}