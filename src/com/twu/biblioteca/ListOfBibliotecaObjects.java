package com.twu.biblioteca;

import java.util.ArrayList;


public class ListOfBibliotecaObjects {

    public ArrayList<BibliotecaObject> inObjects;
    public ArrayList<BibliotecaObject> outObjects;
    public String objectType;

    public ListOfBibliotecaObjects(String objectType) {
        this.objectType = objectType.toLowerCase();
        inObjects = new ArrayList<BibliotecaObject>();
        outObjects = new ArrayList<BibliotecaObject>();
        if(this.objectType.equals("book")){
            inObjects.add(new Book("A", "Tom", "1999"));
            inObjects.add(new Book("B", "Patti", "1988"));
//        inBooks.add(new Book("D", "Georg", "2011", true));
            outObjects.add(new Book("C", "Marta", "2001"));
        }
        else if(this.objectType.equals("movie")){
            inObjects.add(new Movie("Kill Bill", "Tarantino", "2002", "8"));
            inObjects.add(new Movie("Shawshank redemption", "Doe", "1995", "unrated"));
            outObjects.add(new Movie("Star Wars", "Lucas", "2010", "5"));
        }
    }

    public void checkoutBibObj(String objectTitle) {
        for (BibliotecaObject bibObj: inObjects) {
            if (bibObj.getTitle().equals(objectTitle)) {
                inObjects.remove(bibObj);
                outObjects.add(bibObj);
                System.out.println("Thank you! Enjoy the " + this.objectType);
                return;
            }
        }
        System.out.println("Sorry that " + this.objectType + " is not available");
    }

    public void checkinBibObj(String objectTitle) {

        for (BibliotecaObject bibObj: outObjects) {
            if (bibObj.getTitle().equals(objectTitle)) {
                inObjects.add(bibObj);
                outObjects.remove(bibObj);
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