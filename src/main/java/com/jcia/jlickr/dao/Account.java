package com.jcia.jlickr.dao;

public class Account {
    private int idUser;
    private String userName;
    private String password;
    private String gmail;
    private String birthday;
    public Account(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.birthday = "01-01-1998";
        this.gmail = "abc@gmail.com";
    }

    public Account(String userName, String password,String birthday, String gmail){
        this.userName = userName;
        this.birthday = birthday;
        this.gmail = gmail;
        this.password = password;

    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ID = " + idUser+" UserName = "+ this.userName+", Birthdate = "+this.birthday +", Gmail = "+this.gmail +", Password = " + this.password;
    }
}
