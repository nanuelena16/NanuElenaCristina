package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PagPrincipalaActivity extends AppCompatActivity {
    String nume;
    ArrayList<Referinta> lista=new ArrayList<>();
    ListView lv;
    ArrayAdapter<Referinta> adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_principala);

        Dao d=new Dao(getApplicationContext());

        Intent intent=getIntent();
        if(intent!=null) {
            nume=intent.getStringExtra("a");
        }


         listare();

        lv=(ListView)findViewById(R.id.lv_listaMea);
        adaptor=new AdaptorReferinte(this, R.layout.afisare_referinta, lista);
        lv.setAdapter(adaptor);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Referinta referinta=(Referinta)adaptor.getItem(position);

                String titluPJurnal=referinta.getTitluJurnal();
                String anAparitie=String.valueOf(referinta.getAnAparitie());
                String tip=referinta.getTipDocument();
                String titluPub=referinta.getTitluPublicatie();

                String[] ref=new String[5];
                ref[0]=titluPJurnal;
                ref[1]=anAparitie;
                ref[2]=tip;
                ref[3]=titluPub;
                ref[4]=String.valueOf(referinta.getId_ref());

                Intent intent=new Intent(PagPrincipalaActivity.this,AfiseazaReferintaActivity.class);
                intent.putExtra("p",ref);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Referinta referinta = (Referinta)adaptor.getItem(position);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference dbRef =db.getReference("listaMea");
                dbRef.push();
                String key = dbRef.push().getKey();
                dbRef.child(key).setValue(referinta);
                Toast.makeText(getApplicationContext(),"Referinta adaugata!",Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    void listare() {
        Dao d=new Dao(getApplicationContext());
        lista=d.selecteazaToateReferintele(nume);
        lv=(ListView)findViewById(R.id.lv_listaMea);
        adaptor=new AdaptorReferinte(this, R.layout.afisare_referinta, lista);
        lv.setAdapter(adaptor);
    }

    public void restart(View v) {
        listare();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectat=item.getItemId();
        if(selectat==R.id.i_despre) {
            Intent intent = new Intent(this, DespreActivity.class);
            startActivity(intent);
        } else if(selectat==R.id.i_listaReferinte) {
            Intent intent1=new Intent(this, ListaReferinteJSONActivity.class);
            intent1.putExtra("aa",nume);
            startActivity(intent1);
        }
        else if(selectat==R.id.i_adaugaReferinta) {
            Intent intent2=new Intent(this, AdaugaReferintaActivity.class);
            intent2.putExtra("q", nume);
            startActivity(intent2);
        } else if(selectat==R.id.i_grafic) {
            Intent intent3=new Intent(this, GraficActivity.class);
            intent3.putExtra("k", nume);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

    public void raport(View v) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("raportLista.txt", Context.MODE_PRIVATE);
            ObjectOutputStream of = new ObjectOutputStream(fos);
            for(int i=0;i<lista.size();i++) {
                of.writeObject(lista.get(i).toString());
            }

            File file = new File(getApplicationContext().getFilesDir(), "raportLista.txt");

            Context context = getApplicationContext();
            CharSequence text = "Raport creat!";
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
