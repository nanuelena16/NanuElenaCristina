package com.example.elena.proiectcloud;

public class Autor {
    private int idAutor;
    private String nume;
    private String email;

    public Autor() {
    }

    public Autor(int idAutor, String nume, String email) {
        this.idAutor = idAutor;
        this.nume = nume;
        this.email = email;
    }

    public Autor(String nume, String email) {
        this.nume = nume;
        this.email = email;
    }



    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
