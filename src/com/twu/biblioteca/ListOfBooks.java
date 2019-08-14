package com.twu.biblioteca;

import java.util.ArrayList;


public class ListOfBooks {

    private ArrayList<Book> inBooks;
    private ArrayList<Book> outBooks;

    public ListOfBooks() {
        inBooks = new ArrayList<Book>();
        outBooks = new ArrayList<Book>();
        inBooks.add(new Book("A", "Tom", "1999", true));
        inBooks.add(new Book("B", "Patti", "1988", true));
//        inBooks.add(new Book("D", "Georg", "2011", true));
        outBooks.add(new Book("C", "Marta", "2001", false));
    }

    public void checkoutBook(String bookTitle) {
        for (Book book: inBooks) {
            if (book.getTitle().equals(bookTitle)) {
                inBooks.remove(book);
                outBooks.add(book);
                System.out.println("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.println("Sorry that book is not available");
    }

    public void checkinBook(String bookTitle) {
        for (Book book: outBooks) {
            if (book.getTitle().equals(bookTitle)) {
                inBooks.add(book);
                outBooks.remove(book);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
        System.out.println("This is not a valid book to return");
    }

    public void printBooks(boolean returnBook) {
        ArrayList<Book> booksToPrint;

        if (returnBook) {
            booksToPrint = outBooks;
        }
        else {
            booksToPrint = inBooks;
        }
        for (Book book: booksToPrint) {
            System.out.println("\t" + book);
        }
    }

//    public void filterBooks(boolean availability) {
//        for (Integer i = 0; i < allBooks.size(); i++) {
//            Book b = allBooks.get(i);
//            Integer j = i + 1;
//            if (b.isAvailable() == availability) {
//                System.out.println("\t" + j.toString() + ". " + b);
//            }
//        }
//    }
}