package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public Integer getInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Menu of options: " + "\n" + "(1) List of books");
        if(reader.hasNextInt()){
            Integer readLine = reader.nextInt();
            if (readLine == 1)  {
                return readLine;
            }
        }
        System.out.println("Please select a valid option!");
        return getInput();
    }
}
