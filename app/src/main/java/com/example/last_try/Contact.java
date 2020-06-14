package com.example.last_try;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name, number;
    private int imgResource;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    }


