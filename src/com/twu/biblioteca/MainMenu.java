package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookInvalidException;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = 0;
    private ListOfBooks books = new ListOfBooks();

    public void printMenu(){
        String stringMenu = "Menu of options: \n(1) List of books\n(2) Quit biblioteca\n(3) Checkout a book\n(4) Return a book";
        System.out.println(stringMenu);
    }

    public void runMenu() {
        while (this.readLine != 2) {
            chooseAction();
        }
        System.exit(0);
    }

    public void chooseAction(){
        printMenu();
        getInput();
        switch (this.readLine) {
            case 1:
                books.printBooks(true);
            case 2:
                try {
                    System.out.println("Which book do you want to checkout?");
                    chooseBookFromList();
                } catch (BookInvalidException e) {
                    e.printStackTrace();
                }
            case 3:
                // return book
            case 4:
                System.out.println("Goodbye user!");
            default:
                System.out.println("Please select a valid option!");
        }
    }

    public void chooseBookFromList(ListOfBooks books) throws BookInvalidException {
        books.printBooks();
        getInput();
        if (this.readLine < books.allBooks.size() && this.readLine > 0) {
            books.checkoutBook(this.readLine);
        }
        else {
            throw new BookInvalidException();
        }
    }

    public Integer getInput() {
        setReadLine(-1);
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextInt()){
            setReadLine(reader.nextInt());
        }
        return this.readLine;
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
