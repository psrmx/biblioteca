package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookInvalidException;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = 0;
    private ListOfBooks books = new ListOfBooks();

    public void printMenu(){
        String stringMenu = "Menu of options: \n(1) List of books\n(2) Quit biblioteca\n(3) Checkout a book";
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
        if (this.readLine == 1) {
            books.printBooks();
        }
        else if (this.readLine == 2) {
            System.out.println("Goodbye user!");
        }
        else if (this.readLine == 3) {
            try {
                chooseBookToCheckout();
            } catch (BookInvalidException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Please select a valid option!");
        }
    }

    public void chooseBookToCheckout() throws BookInvalidException {
        System.out.println("Which book do you want to checkout?");
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
