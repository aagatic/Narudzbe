package com.example.narudzbe.narudzbe;


public class Narudzba {

    private String stol;

    public Narudzba(String stol) {
        this.stol = stol;
    }

    public String getStol() {
        return stol;
    }

    public void setStol(String stol) {
        this.stol = stol;
    }

    @Override
    public String toString() {
        return "Narudzba{" +
                "stol='" + stol + '\'' +
                '}';
    }
}
