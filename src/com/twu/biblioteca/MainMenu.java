package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = -1;
    private ListOfBibliotecaObjects books = new ListOfBibliotecaObjects("book");
    private ListOfBibliotecaObjects movies = new ListOfBibliotecaObjects("movie");

    public void printMenu(){
        String stringMenu = "Menu of options: \n(1) List of books\n(2) Checkout a book\n(3) Return a book\n(4) Quit Biblioteca\n(5) List of movies\n(6) Checkout a movie";
        System.out.println(stringMenu);
    }

    public void runMenu() {
        while (readLine != 4) {
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
                books.printBibObj(false);
                System.out.println("Enter title of the book you want to checkout:");
                String bookTitle = getInputString();
                books.checkoutBibObj(bookTitle);
                return;
            case 3:
                books.printBibObj(true);
                System.out.println("Enter title of the book you want to return:");
                bookTitle = getInputString();
                books.checkinBibObj(bookTitle);
                return;
            case 4:
                System.out.println("Goodbye user!");
                return;
            case 5:
                movies.printBibObj(false);
                return;
            case 6:
                movies.printBibObj(false);
                System.out.println("Enter title of the movie you want to checkout:");
                String movieTitle = getInputString();
                movies.checkoutBibObj(movieTitle);
                return;
            case 7:
                movies.printBibObj(true);
                System.out.println("Enter title of the movie you want to return:");
                movieTitle = getInputString();
                movies.checkinBibObj(movieTitle);
                return;
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
        return reader.nextLine();
    }

    public void setReadLine(Integer readLine) {
        this.readLine = readLine;
    }
}
