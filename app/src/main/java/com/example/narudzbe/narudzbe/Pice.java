package com.example.narudzbe.narudzbe;


public class Pice {
    private String narudzba;
    private String kategorija;
    private String ime;
    private String cijena;

    public String getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(String narudzba) {
        this.narudzba = narudzba;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Pice(String narudzba, String kategorija, String ime, String cijena) {

        this.narudzba = narudzba;
        this.kategorija = kategorija;
        this.ime = ime;
        this.cijena = cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getCijena() {

        return cijena;
    }
}
