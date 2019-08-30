package com.company.model;

public class Administrator extends Person {
    private String login;
    private String password;

    public Administrator(int id, String name, String phone, String address, String login, String password) {
        super(id, name, phone, address);
        this.login = login;
        this.password = password;
    }

    public Administrator(String name, String phone, String address, String login, String password) {
        super(name, phone, address);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
