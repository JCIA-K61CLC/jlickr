package com.jcia.jlickr.login;

public class Account {
    String userName;
    String password;

    public Account(String userName, String password){
        this.userName = userName;
        this.password = userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserName = "+ this.userName +" Password = " + this.password;
    }
}
