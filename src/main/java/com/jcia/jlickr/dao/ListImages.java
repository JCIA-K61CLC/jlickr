package com.jcia.jlickr.dao;

import java.io.InputStream;

public class ListImages {
    private int numOrder;
    private String link;
    //private InputStream link;
    public ListImages(int numOrder, String link){
        this.numOrder = numOrder;
        this.link = link;
    }
    /*public ListImages(int numOrder, InputStream link){
        this.numOrder = numOrder;
        this.link = link;
    }*/
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getNumOrder() {

        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

}
