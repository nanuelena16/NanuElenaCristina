package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class AfiseazaReferintaActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<Referinta> adaptor;
    String[] date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afiseaza_referinta);

        Intent intent=getIntent();
        if(intent!=null) {
            date=intent.getStringArrayExtra("p");
        }

        TextView tv_jurnal=(TextView)findViewById(R.id.tv_titluJ);
        tv_jurnal.setText("Titlu Jurnal: " + date[0]);
        TextView tv_an=(TextView)findViewById(R.id.tv_anAp);
        tv_an.setText("An aparitie: " + date[1]);
        TextView tv_tip=(TextView)findViewById(R.id.tv_tip);
        tv_tip.setText("Tip document: " + date[2]);
        TextView tv_pub=(TextView)findViewById(R.id.tv_titluD);
        tv_pub.setText("Titlu document: " + date[3]);
    }

    public void stergere(View v) {
         Dao d=new Dao(getApplicationContext());
         d.sterge(date[4]);

        Context context = getApplicationContext();
        CharSequence text = "Referinta a fost stearsa";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void raport(View v) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(date[4]+".txt", Context.MODE_PRIVATE);
            ObjectOutputStream of = new ObjectOutputStream(fos);
            of.writeObject(date[0]+"\n"+date[1]+"\n"+date[2]+"\n"+date[3]);

            File file = new File(getApplicationContext().getFilesDir(), date[4]+".txt");

            Context context = getApplicationContext();
            CharSequence text = "Raport generat!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
