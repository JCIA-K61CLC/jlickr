package com.jcia.jlickr.dao;

import java.sql.Blob;

public class Image {
    private int idUser;
    private String link;
    private String caption;
    private String title;
    private String postdate;
    private Blob photo;

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Image(int idUser, String link){
        this.idUser = idUser;
        this.link = link;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
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
