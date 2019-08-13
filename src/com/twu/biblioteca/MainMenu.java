package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    Integer readLine;

    public void printMenu(){
        System.out.println("Menu of options: " + "\n" + "(1) List of books" + "\n" + "(2) Quit biblioteca");
    }

    public void chooseAction(Integer readLine){
        if (readLine == 1)  {
            //TODO: remove the ListOfBooks and just pass them to this Class
            ListOfBooks books = new ListOfBooks();
            books.addBook(new Book("B", "Patti", "1989"));
            books.addBook(new Book("C", "Marta", "2001"));
            books.printBooks();
            getInput();
        }
        if (readLine == 2){
            System.out.println("Goodbye user!");
        }
        else{
            System.out.println("Please select a valid option!");
            getInput();
        }
    }

    public void getInput() {
        Scanner reader = new Scanner(System.in);
        printMenu();
        if(reader.hasNextInt()){
            Integer readLine = reader.nextInt();
            chooseAction(readLine);
        }
    }
}
