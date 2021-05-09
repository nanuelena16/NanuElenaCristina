package com.example.elena.proiectcloud;


public class User {
    public int idd;
    public String nume;
    public String parola;

    public User(String nume, String parola) {
        this.nume = nume;
        this.parola = parola;
    }

    public User() {

    }

    public User(int idd, String nume, String parola) {
        this.idd = idd;
        this.nume = nume;
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idd +
                ", nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
