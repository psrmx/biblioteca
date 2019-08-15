package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Integer readLine = -1;
    private ListOfBibliotecaObjects books = new ListOfBibliotecaObjects("book");
    private ListOfBibliotecaObjects movies = new ListOfBibliotecaObjects("movie");
    public LoginService session = new LoginService();

    public void printMenu(){
        String extraMenuOption = "";
        if (!session.currentUser.username.isEmpty()) {
            extraMenuOption = "(7) Display user information\n";
        }
            String stringMenu =
                    "Menu of options: \n" +
                    "(1) List of books\n" +
                    "(2) Checkout a book\n" +
                    "(3) Return a book\n" +
                    "(4) List of movies\n" +
                    "(5) Checkout a movie\n" +
                    "(6) Return a movie\n" + extraMenuOption +
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
                books.printAllInBibObj();
                return;
            case 2:
                processToCheckoutObject(books);
                return;
            case 3:
                processToCheckinObject(books);
                return;
            case 4:
                movies.printAllInBibObj();
                return;
            case 5:
                processToCheckoutObject(movies);
                return;
            case 6:
                processToCheckinObject(movies);
                return;
            case 7:
                if (!session.currentUser.username.isEmpty()) {
                    System.out.println(session.currentUser);
                }
                else {
                    System.out.println("Please select a valid option!");
                }
                return;
            case 9:
                System.out.println("Goodbye user!");
                return;
            default:
                System.out.println("Please select a valid option!");
        }
    }

    public void validateUser() {
            System.out.print("Please enter your username: ");
            String inputUsername = getInputString();
            System.out.print("Please enter your password: ");
            String inputPassword = getInputString();
            session.authenticate(inputUsername, inputPassword);
    }

    public void processToCheckoutObject(ListOfBibliotecaObjects bibObjs) {
        if (session.currentUser.username.isEmpty()) {
            validateUser();
        }
        else {
            if (bibObjs.printAllInBibObj() > 0) {
                System.out.println("Enter title of the " + bibObjs.objectType + " you want to checkout:");
                String objTitle = getInputString();
                bibObjs.checkoutBibObj(objTitle, session.currentUser);
            }
            else{
                System.out.println("No "+ bibObjs.objectType + " to checkout");
            }
        }
    }

    public void processToCheckinObject(ListOfBibliotecaObjects bibObjs) {
        if (session.currentUser.username.isEmpty()) {
            validateUser();
        }
        else {
            if (bibObjs.printBibObjPerUser(bibObjs.outObjects, session.currentUser) > 0) {
                System.out.println("Enter title of the " + bibObjs.objectType + " you want to return:");
                String objTitle = getInputString();
                bibObjs.checkinBibObj(objTitle);
            }
            else {
                System.out.println("You don't have any "+ bibObjs.objectType + " to checkin");
            }
        }
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
