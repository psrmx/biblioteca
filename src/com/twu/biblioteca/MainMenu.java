package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = -1;
    private ListOfBibliotecaObjects books = new ListOfBibliotecaObjects("book");
    private ListOfBibliotecaObjects movies = new ListOfBibliotecaObjects("movie");

    public void printMenu(){
        String stringMenu =
                "Menu of options: \n" +
                "(1) List of books\n" +
                "(2) Checkout a book\n" +
                "(3) Return a book\n" +
                "(4) List of movies\n" +
                "(5) Checkout a movie\n" +
                "(6) Return a movie\n" +
                "(9) Quit Biblioteca";

        System.out.println(stringMenu);
    }

    public void runMenu() {
        while (readLine != 9) {
            chooseAction();
        }
        System.exit(0);
    }

    public void chooseAction(){
        printMenu();
        getInput();
        switch (readLine) {
            case 1:
                books.printBibObj(false);
                return;
            case 2:
                processToCheckoutObject(books);
                return;
            case 3:
                processToCheckinObject(books);
                return;
            case 4:
                movies.printBibObj(false);
                return;
            case 5:
                processToCheckoutObject(movies);
                return;
            case 6:
                processToCheckinObject(movies);
                return;
            case 9:
                System.out.println("Goodbye user!");
                return;
            default:
                System.out.println("Please select a valid option!");
        }
    }

    public void processToCheckoutObject(ListOfBibliotecaObjects bibObjs) {
        bibObjs.printBibObj(false);
        System.out.println("Enter title of the " + bibObjs.objectType + " you want to checkout:");
        String objTitle = getInputString();
        bibObjs.checkoutBibObj(objTitle);
    }

    public void processToCheckinObject(ListOfBibliotecaObjects bibObjs) {
        bibObjs.printBibObj(true);
        System.out.println("Enter title of the " + bibObjs.objectType + " you want to return:");
        String objTitle = getInputString();
        bibObjs.checkinBibObj(objTitle);
    }

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
        return reader.nextLine();
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
