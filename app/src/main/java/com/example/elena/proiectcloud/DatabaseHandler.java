package com.example.elena.proiectcloud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, ConstanteDatabaseUser.DB_NUME, null, ConstanteDatabaseUser.versiune);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(ConstanteDatabaseUser.CREARE_TBELA_USER);
            db.execSQL(ConstanteDatabaseReferinte.CREARE_TABELA_REFERINTA);
            this.db=db;
        } catch(SQLiteException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versiuneVeche, int versiuneNoua) {
        try {
            db.execSQL(ConstanteDatabaseUser.STERGERE_TABELA_USER);
            db.execSQL(ConstanteDatabaseReferinte.STERGERE_TABELA_REFERINTA);
            onCreate(db);
        } catch(SQLiteException ex) {
            ex.printStackTrace();
        }
    }
}
