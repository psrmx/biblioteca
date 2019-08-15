package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LoginService {

    public User currentUser = new User();

    List<User> users = new ArrayList<>();
    {
        User user1 = new User("111-1111", "1");
        users.add(user1);
        User user2 = new User("222-2222", "2");
        users.add(user2);
        User user3 = new User("333-3333", "3");
        users.add(user3);
    }


    public void authenticate(String username, String password) {
        for(User userInCollection : users){
            if(userInCollection.username.equals(username) && userInCollection.password.equals(password)){
                currentUser = userInCollection;
                return;
            }
        }
        System.out.println("Invalid user!");
    }
}
