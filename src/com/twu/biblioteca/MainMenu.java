package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = 0;

    public void printMenu(){
        System.out.println("Menu of options: " + "\n" + "(1) List of books" + "\n" + "(2) Quit biblioteca");
    }

    public void chooseAction(){
        if (this.readLine == 1)  {
            //TODO: remove the ListOfBooks and just pass them to this Class
            ListOfBooks books = new ListOfBooks();
            books.addBook(new Book("B", "Patti", "1989"));
            books.addBook(new Book("C", "Marta", "2001"));
            books.printBooks();
            getInput();
        }
        if (this.readLine == 2){
            System.out.println("Goodbye user!");
            System.exit(0);
        }
        else{
            System.out.println("Please select a valid option!");
            getInput();
        }
    }

    public Integer getInput() {
        printMenu();
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextInt()){
            readLine = reader.nextInt();
            setReadLine(readLine);
        }
        chooseAction();
        return readLine;
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
