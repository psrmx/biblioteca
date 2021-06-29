package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    @Test
    public void ShouldLoginUserWithCorrectCredentials() throws Exception {
        // if user exists
        String username = "111-1111";
        String password = "1";
        LoginService loginService = new LoginService();
        // when authenticating
        loginService.authenticate(username, password);
        // the username and password must be valid
        assertThat(loginService.currentUser.username, is("111-1111"));
        assertThat(loginService.currentUser.password, is("1"));
    }

    @Test
    public void ShouldNotLoginUserWithIncorrectCredentials()throws Exception {
        // Redirect System.out to buffer
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        // if user doesn't exist
        String username = "666-6666";
        String password = "not_a_user";
        LoginService loginService = new LoginService();
        // when authenticating
        loginService.authenticate(username, password);
        // throw error message
        assertThat(contentOut.toString(), is("Invalid user!\n"));
    }
}
