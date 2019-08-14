package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = 0;
    private ListOfBooks books = new ListOfBooks();

    public void printMenu(){
        System.out.println("Menu of options: " + "\n" + "(1) List of books" + "\n" + "(2) Quit biblioteca");
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
        if (this.readLine == 1)  {
            books.printBooks();
        }
        if(this.readLine == 2){
            System.out.println("Goodbye user!");
        }
        else{
            System.out.println("Please select a valid option!");
        }
    }

    public Integer getInput() {
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextInt()){
            setReadLine(reader.nextInt());
        }
        else {
            setReadLine(0);
        }
        return this.readLine;
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
