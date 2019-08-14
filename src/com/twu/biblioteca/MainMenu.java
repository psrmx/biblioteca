package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = -1;
    private ListOfBooks books = new ListOfBooks();

    public void printMenu(){
        String stringMenu = "Menu of options: \n(1) List of books\n(2) Quit biblioteca\n(3) Checkout a book\n(4) Return a book";
        System.out.println(stringMenu);
    }

    public void runMenu() {
        while (readLine != 2) {
            chooseAction();
        }
        System.exit(0);
    }

    public void chooseAction(){
        printMenu();
        getInput();
        switch (readLine) {
            case 1:
                books.printBooks(false);
            case 2:
                books.printBooks(false);
                System.out.println("Enter title of the book you want to checkout:");
                String bookTitle = getInputString();
                books.checkoutBook(bookTitle);
            case 3:
                books.printBooks(true);
                System.out.println("Enter title of the book you want to return:");
                bookTitle = getInputString();
                books.checkinBook(bookTitle);
            case 4:
                System.out.println("Goodbye user!");
            default:
                System.out.println("Please select a valid option!");
        }
    }

//    public void chooseBookFromList(ListOfBooks books) throws BookInvalidException {
//        books.printBooks();
//        getInput();
//        if (this.readLine < books.allBooks.size() && this.readLine > 0) {
//            books.checkoutBook(this.readLine);
//        }
//        else {
//            throw new BookInvalidException();
//        }
//    }

    public Integer getInput() {
        setReadLine(-1);
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextInt()){
            setReadLine(reader.nextInt());
        }
        return readLine;
    }

    public String getInputString() {
        Scanner reader = new Scanner(System.in);
        return reader.next();
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
