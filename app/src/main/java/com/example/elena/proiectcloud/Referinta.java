package com.example.elena.proiectcloud;

import java.io.Serializable;
import java.util.ArrayList;


public class Referinta implements Serializable{
    private String titluJurnal;
    private int anAparitie;
    private String tipDocument;
    private String titluPublicatie;
    private ArrayList<Autor> autori;
    private int id_ref;
    private int id;

    public int lungime() {
        return autori.size();
    }

    public Referinta() {
    }

    public Referinta(String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie, ArrayList<Autor> autori, int id_ref, int id) {
        this.titluJurnal = titluJurnal;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
        this.autori = autori;
        this.id_ref = id_ref;
        this.id = id;
    }

    public Referinta(String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie, ArrayList<Autor> autori, int id) {
        this.titluJurnal = titluJurnal;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
        this.autori = autori;
        this.id = id;
    }

    public Referinta(String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie, ArrayList<Autor> autori) {
        this.titluJurnal = titluJurnal;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
        this.autori = autori;
    }

    public Referinta(int id, String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie, ArrayList<Autor> autori) {
        this.id_ref=id;
        this.titluJurnal = titluJurnal;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
        this.autori = autori;
    }

    public Referinta(int id, String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie) {
        this.titluJurnal = titluJurnal;
        this.id_ref=id;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
    }

    public Referinta(String titluJurnal, int anAparitie, String tipDocument, String titluPublicatie, int id_ref, int id) {
        this.titluJurnal = titluJurnal;
        this.anAparitie = anAparitie;
        this.tipDocument = tipDocument;
        this.titluPublicatie = titluPublicatie;
        this.id_ref = id_ref;
        this.id = id;
    }

    public void adaugaAutor(Autor autor) {
        this.autori.add(autor);
    }

    @Override
    public String toString() {
        return "Referinta{" +
                "titluJurnal='" + titluJurnal + '\'' +
                ", anAparitie=" + anAparitie +
                ", tipDocument='" + tipDocument + '\'' +
                ", titluPublicatie='" + titluPublicatie + '\'' +
                ", autori=" + autori +
                '}';
    }

    public String getTitluJurnal() {
        return titluJurnal;
    }

    public void setTitluJurnal(String titluJurnal) {
        this.titluJurnal = titluJurnal;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    public String getTipDocument() {
        return tipDocument;
    }

    public void setTipDocument(String tipDocument) {
        this.tipDocument = tipDocument;
    }

    public String getTitluPublicatie() {
        return titluPublicatie;
    }

    public void setTitluPublicatie(String titluPublicatie) {
        this.titluPublicatie = titluPublicatie;
    }

    public Autor getAutori(int i) {
        return autori.get(i);
    }

    public void setAutori(ArrayList<Autor> autori) {
        this.autori = autori;
    }

    public int getId_ref() {
        return id_ref;
    }

    public void setId_ref(int id_ref) {
        this.id_ref = id_ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
