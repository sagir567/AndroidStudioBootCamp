package com.mastercoding.sportsapp;

public class Sport {

    private int sportImage;
    private String sportName;


    public int getSportImage() {
        return sportImage;
    }

    public void setSportImage(int sportImage) {
        this.sportImage = sportImage;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Sport(String sportName,int sportImage) {
        this.sportImage = sportImage;
        this.sportName = sportName;
    }
}
