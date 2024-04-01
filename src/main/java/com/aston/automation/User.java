package com.aston.automation;

public class User {
    private String login;

    public User(String login) {
        this.login = login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login;
    }

    public String getLogin() {
        return login;
    }
}
