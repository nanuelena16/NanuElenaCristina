package com.example.elena.proiectcloud;


public interface ConstanteDatabaseUser {
    public final String DB_NUME="bazadate.db";
    public final int versiune=1;

    public String DENUMIRE_TABELA_USER="user";
    public String COLOANA_ID="col_id";
    public String COLOANA_NUME="col_nume";
    public String COLOANA_PAROLA="col_parola";

    public String CREARE_TBELA_USER="CREATE TABLE " + DENUMIRE_TABELA_USER + "(" + COLOANA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                      COLOANA_NUME + " text, " + COLOANA_PAROLA + " text)";

    public String STERGERE_TABELA_USER="DROP TABLE IF EXISTS " + DENUMIRE_TABELA_USER;

}
