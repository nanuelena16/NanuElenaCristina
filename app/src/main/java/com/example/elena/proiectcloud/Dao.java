package com.example.elena.proiectcloud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;



public class Dao implements ConstanteDatabaseUser, ConstanteDatabaseReferinte {
    private DatabaseHandler dbHandler;
    SQLiteDatabase db;

    public Dao (Context context) {
        dbHandler=new DatabaseHandler(context);
        db=dbHandler.getWritableDatabase();
    }

    public long adaugaUserPtClasa(User user) {
        long rezInsert=0;
        ContentValues valoriUser=new ContentValues();

        try {
            valoriUser.put(COLOANA_NUME, user.getNume());
            //valoriUser.put(ConstanteDatabaseUser.COLOANA_ID, user.getIdd());
            valoriUser.put(COLOANA_PAROLA, user.getParola());

            rezInsert=db.insert(DENUMIRE_TABELA_USER,null,valoriUser);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rezInsert;
    }

    public long adaugaReferintaPtClasa(Referinta referinta) {
        long rezInsert=0;
        ContentValues valoriRef=new ContentValues();

        try {
            valoriRef.put(COLOANA_TITLU_PUBLICATIE, referinta.getTitluJurnal());
            //valoriRef.put(COLOANA_IDD, referinta.getId_ref());
            valoriRef.put(COLOANA_AN_APARITIE, referinta.getAnAparitie());
            valoriRef.put(COLOANA_TIP_DOCUMENT, referinta.getTipDocument());
            valoriRef.put(COLOANA_TITLU_DOCUMENT, referinta.getTitluPublicatie());
            valoriRef.put(ConstanteDatabaseReferinte.COLOANA_ID, referinta.getId());

            rezInsert=db.insert(DENUMIRE_TABELA_REFERINTA,null,valoriRef);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rezInsert;
    }

    public int existaUser(User user) {
        int rezultat=0;

        Cursor c;

        c = db.rawQuery("SELECT * FROM " + DENUMIRE_TABELA_USER + " WHERE " + COLOANA_NUME + "='" + user.getNume() + "'" + " OR " +
                                                                            COLOANA_PAROLA + "='" + user.getParola() + "'" + " OR " +
                                                                            ConstanteDatabaseUser.COLOANA_ID + "='" + user.getIdd() + "'", null);

        if(c.getCount() > 0  && c.getColumnCount() > 0 && c!= null) {
            rezultat=1;
        }

        return rezultat;
    }

    public int returnId(String nume) {
        int id=0;

        Cursor c;
        c=db.rawQuery("SELECT * FROM " + DENUMIRE_TABELA_USER + " WHERE " + COLOANA_NUME+ "='" + nume + "'", null);
        while(c.moveToNext()) {
            int index = c.getColumnIndex(ConstanteDatabaseUser.COLOANA_ID);
            //id=c.getCount();
            if (c.getCount() != 0) {
                id = c.getInt(index);
            } else id = 0;
        }
        return id;
    }

    public ArrayList<Referinta> selecteazaToateReferintele(String nume) {
        int id=returnId(nume);
        ArrayList<Referinta> lista=new ArrayList<>();

        Cursor c;
        c=db.rawQuery("SELECT * FROM " + DENUMIRE_TABELA_REFERINTA + " WHERE " + ConstanteDatabaseUser.COLOANA_ID + "='" + id + "'", null);

        while (c.moveToNext()) {
            int indexIdRef=c.getColumnIndex(COLOANA_IDD);
            int indexTitluJurnal=c.getColumnIndex(COLOANA_TITLU_PUBLICATIE);
            int indexAnAparitie=c.getColumnIndex(COLOANA_AN_APARITIE);
            int indexTip=c.getColumnIndex(COLOANA_TIP_DOCUMENT);
            int indexTitluDocument=c.getColumnIndex(COLOANA_TITLU_DOCUMENT);

            lista.add(new Referinta(c.getString(indexTitluJurnal), c.getInt(indexAnAparitie), c.getString(indexTip), c.getString(indexTitluDocument),
                                    c.getInt(indexIdRef), id));
        }
        c.close();

        return lista;
    }

    public void sterge(String id)
    {
        db.execSQL("DELETE FROM " + DENUMIRE_TABELA_REFERINTA + " WHERE "+ COLOANA_IDD + "='"+id+"'");
    }
}
