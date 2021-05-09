package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class GraficActivity extends AppCompatActivity {
    String nume;
    ArrayList<Referinta> lista;
//    Canvas canvas;
//    Bitmap b;

    Paint pen=new Paint();
    int numarDreptunghiuri;
    int[] valoriAni;
    int[] aniReferinte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafic);

        Intent intent=getIntent();
        if(intent!=null) {
            nume=intent.getStringExtra("k");
        }

        Dao d=new Dao(getApplicationContext());

        lista=d.selecteazaToateReferintele(nume);

        desenare();

        LinearLayout ll=(LinearLayout) findViewById(R.id.layOut);
        ll.addView(new Desen(this));

    }

    public void desenare() {

        int[] vector=new int[lista.size()];
        for(int i=0;i<lista.size();i++) {
            vector[i]=lista.get(i).getAnAparitie();
        }

        boolean k = true;
        int j = 0;
        int temp;
        while (k) {
            k = false;
            j++;
            for (int i = 0; i < vector.length - j; i++) {
                if (vector[i] > vector[i + 1]) {
                    temp = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = temp;
                    k = true;
                }
            }
        }

        int nr=1;
        int index=1;
        for(int i=0;i<vector.length-1;i++) {
            if(vector[i]==vector[i+1]) {
                index++;
            } else {
                index=0;
                nr++;
            }
        }

        int[] vector2=new int[nr];
        int[] vector3=new int[nr];
        int contor=0;
        vector2[contor]=1;
        for(int i=0;i<vector.length-1;i++) {
            if(vector[i]==vector[i+1]) {
                vector2[contor]++;
            } else {
                vector3[contor]=vector[i];
                contor++;
                vector2[contor]=1;
            }
        }

        if(vector[vector.length-1]!=vector[vector.length-2]) {
            vector3[nr-1]=vector[vector.length-1];
        } else {
            vector3[nr-1]=vector[vector.length-1];
        }

        grafic(vector2,vector3,nr);
    }






    public void grafic(int[] valori, int[] ani, int nr) {
        numarDreptunghiuri=nr;

        valoriAni=new int[nr];
        for(int i=0;i<nr;i++) {
            valoriAni[i]=valori[i];
        }

        aniReferinte=new int[nr];
        for(int i=0;i<nr;i++) {
            aniReferinte[i]=ani[i];
        }

    }



    public class Desen extends View {
        public Desen(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            pen.setColor(Color.BLUE);
            pen.setStrokeWidth(15);

            canvas.drawLine(90, 0, 90, getHeight() - 90, pen);
            canvas.drawLine(90, getHeight()-90, getWidth(), getHeight()-90, pen);

            int lungimeDreptunghi = (getWidth()-90) / (numarDreptunghiuri * 2 + 1);

            int maximInaltime =  getHeight()-50;

            int valoareMaxima = 0;
            for (int i = 0; i < valoriAni.length; i++) {
                if (valoareMaxima < valoriAni[i]) {
                    valoareMaxima = valoriAni[i];
                }
            }

            int parteInaltime = maximInaltime / valoareMaxima;

            for (int i = 0; i < numarDreptunghiuri; i++) {
                canvas.drawRect(90 + i*2*lungimeDreptunghi + lungimeDreptunghi, 50+(valoareMaxima-valoriAni[i])*parteInaltime, lungimeDreptunghi * 2 * (i + 1)+90, getHeight()-90, pen);
                pen.setColor(Color.BLACK);
                pen.setTextSize(40);
                canvas.drawText(String.valueOf(aniReferinte[i]),90 + i*2*lungimeDreptunghi + lungimeDreptunghi + lungimeDreptunghi*1/4, getHeight()-30,pen );
                canvas.drawText(String.valueOf(valoriAni[i]), 50,50+(valoareMaxima-valoriAni[i])*parteInaltime-5, pen );
                pen.setColor(Color.BLUE);
            }
        }


    }




}
