package com.jcia.jlickr.dao;

public class ListImages {
    private int numOrder;
    private String link;
    public ListImages(int numOrder, String link){
        this.numOrder = numOrder;
        this.link = link;
    }
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
