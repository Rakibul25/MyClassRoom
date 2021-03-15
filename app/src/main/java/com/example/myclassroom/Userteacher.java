package com.example.myclassroom;

public class Userteacher {
    private String user_name;
    private String password;

    public Userteacher() {
    }

    public Userteacher(String username, String pasword) {
        this.user_name = username;
        this.password = pasword;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
