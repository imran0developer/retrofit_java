package com.unitapplications.retro.Models;

public class MemeModel {

    String header;
    String image;

    public MemeModel() {
    }

    public MemeModel(String header, String image) {
        this.header = header;
        this.image = image;
    }

    public MemeModel(String image) {
        this.image = image;
    }

    public String getheader() {
        return header;
    }

    public void setheader(String header) {
        this.header = header;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}