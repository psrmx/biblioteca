package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        WelcomeMessage message = new WelcomeMessage();
        System.out.println(message);

        MainMenu menu = new MainMenu();
        if (menu.getInput() == 1) {
            ListOfBooks books = new ListOfBooks();
            books.addBook(new Book("B", "Patti", "1989"));
            books.addBook(new Book("C", "Marta", "2001"));
            books.printBooks();
        }

    }

}
