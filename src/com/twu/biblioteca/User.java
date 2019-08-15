package com.twu.biblioteca;

public class User {
    public String username;
    public String password;
    private String name;
    private String email;
    private String phone;

    public User(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        this.username = "";
        this.password = "";
    }

    private String getPhone() { return this.phone; }

    private String getEmail() { return this.email; }

    private String getName() { return this.name; }

    @Override
    public String toString() {
        return String.format(this.getName() + " | " + this.getEmail() + " | " + this.getPhone());
    }
}
