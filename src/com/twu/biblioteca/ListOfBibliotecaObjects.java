package com.twu.biblioteca;

import java.util.ArrayList;


public class ListOfBibliotecaObjects {

    public ArrayList<BibliotecaObject> inObjects;
    public ArrayList<BibliotecaObject> outObjects;
    private String objectType;

    public ListOfBibliotecaObjects(String objectType) {
        this.objectType = objectType;
        inObjects = new ArrayList<BibliotecaObject>();
        outObjects = new ArrayList<BibliotecaObject>();
        inObjects.add(new BibliotecaObject("A", "Tom", "1999"));
        inObjects.add(new BibliotecaObject("B", "Patti", "1988"));
//        inBooks.add(new Book("D", "Georg", "2011", true));
        outObjects.add(new BibliotecaObject("C", "Marta", "2001"));
    }

    public void checkoutBibObj(String bookTitle) {
        for (BibliotecaObject bibObj: inObjects) {
            if (bibObj.getTitle().equals(bookTitle)) {
                inObjects.remove(bibObj);
                outObjects.add(bibObj);
                System.out.println("Thank you! Enjoy the " + this.objectType);
                return;
            }
        }
        System.out.println("Sorry that " + this.objectType + " is not available");
    }

    public void checkinBibObj(String bookTitle) {
        for (BibliotecaObject bibObjc: outObjects) {
            if (bibObjc.getTitle().equals(bookTitle)) {
                inObjects.add(bibObjc);
                outObjects.remove(bibObjc);
                System.out.println("Thank you for returning the " + this.objectType);
                return;
            }
        }
        System.out.println("This is not a valid " + this.objectType + " to return");
    }

    public void printBibObj(boolean returnBook) {
        ArrayList<BibliotecaObject> booksToPrint;

        if (returnBook) {
            booksToPrint = outObjects;
        }
        else {
            booksToPrint = inObjects;
        }
        for (BibliotecaObject bibObj: booksToPrint) {
            System.out.println("\t" + bibObj);
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