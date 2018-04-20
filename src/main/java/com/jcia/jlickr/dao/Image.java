package com.jcia.jlickr.dao;

public class Image {
    private int idUser;
    private String link;

    public Image(int idUser, String link){
        this.idUser = idUser;
        this.link = link;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "id user = " + idUser + ", link = " + link;
    }
}
