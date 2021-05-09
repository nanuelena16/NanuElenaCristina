package com.example.elena.proiectcloud;

public interface ConstanteDatabaseReferinte extends ConstanteDatabaseUser {
    public final String DB_NUME="bazadate.db";
    public final int versiune=1;

    public String DENUMIRE_TABELA_REFERINTA="referinta";
    public String COLOANA_IDD="col_id_ref";
    public String COLOANA_TITLU_PUBLICATIE="col_titlu_pub";
    public String COLOANA_AN_APARITIE="col_an_aparitie";
    public String COLOANA_TIP_DOCUMENT="col_tip_document";
    public String COLOANA_TITLU_DOCUMENT="col_titlu_document";
    public String COLOANA_ID="col_id";

    public String STERGERE_TABELA_REFERINTA="DROP TABLE IF EXISTS " + DENUMIRE_TABELA_REFERINTA;

    public String CREARE_TABELA_REFERINTA="CREATE TABLE " + DENUMIRE_TABELA_REFERINTA + "(" + COLOANA_IDD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                            COLOANA_TITLU_PUBLICATIE + " text, " + COLOANA_AN_APARITIE + " integer, " +
                                                            COLOANA_TIP_DOCUMENT + " text, " + COLOANA_TITLU_DOCUMENT + " text, " +
                                                            COLOANA_ID + " integer, " +
                                                            " FOREIGN KEY(" + COLOANA_ID + ") REFERENCES " + DENUMIRE_TABELA_USER + " (" +
                                                            COLOANA_ID +"))";
}
