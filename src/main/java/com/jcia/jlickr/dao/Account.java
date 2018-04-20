package com.jcia.jlickr.dao;

public class Account {
    private int idUser;
    private String userName;
    private String password;
    private String gmail;
    private String birthdate;

    public Account(String userName,String birthdate, String gmail, String password){
        this.userName = userName;
        this.birthdate = birthdate;
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

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return birthdate;
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
        return "ID = " + idUser+" UserName = "+ this.userName+", Birthdate = "+this.birthdate+", Gmail = "+this.gmail +", Password = " + this.password;
    }
}
