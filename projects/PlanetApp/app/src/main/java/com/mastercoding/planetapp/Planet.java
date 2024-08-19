package com.mastercoding.planetapp;

import androidx.annotation.NonNull;

public class Planet {
    private String planetName;
    private String moonCount;
    private int planetImage;


    public Planet( String name, String moons, int image){
        if(name == null || moons == null ) throw new NullPointerException();
        this.moonCount = moons;
        this.planetName =  name;
        this.planetImage = image;
    }
    // getters
    @NonNull
    public String getPlanetName(){return this.planetName;}
    @NonNull
    public String getMoonCount(){return this.moonCount;}
    public int getPlanetImage(){return this.planetImage;}
    // Setters
    public void setMoonCount(String moonCount) {this.moonCount = moonCount;}
    public void setPlanetImage(int planetImage) {this.planetImage = planetImage;}
    public void setPlanetName(String planetName) {this.planetName = planetName;}
}
