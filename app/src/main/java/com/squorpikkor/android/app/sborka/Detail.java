package com.squorpikkor.android.app.sborka;

 // Created by VadimSquorpikkor on 28.03.2017.

public class Detail {
    private String name;
    private String number;
    private String imagePath;

    public Detail (String name, String number) {
        this.name = name;
        this.number = number;
    }

    //region SETTERS & GETTERS
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    //endregion
}
