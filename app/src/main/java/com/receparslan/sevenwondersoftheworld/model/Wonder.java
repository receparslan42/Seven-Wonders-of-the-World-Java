package com.receparslan.sevenwondersoftheworld.model;

public class Wonder {

    final String name;
    final String country;
    final String information;
    final int image;

    public Wonder(String name, String country, String information, int image) {
        this.name = name;
        this.country = country;
        this.information = information;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getInformation() {
        return information;
    }

    public int getImage() {
        return image;
    }
}
