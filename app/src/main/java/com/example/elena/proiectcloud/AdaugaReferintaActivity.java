package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AdaugaReferintaActivity extends AppCompatActivity {
    ArrayList<Autor> autori=new ArrayList<>();
    String[] stringAutori;
    String nume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_referinta);

        Intent intent=getIntent();
        if(intent!=null) {
            nume=intent.getStringExtra("q");
        }
    }

    public void deschidePaginaAutori(View v) {
        Intent intent=new Intent(this, ScriereAutoriActivity.class);
        startActivityForResult(intent,1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                //String strEditText = data.getStringExtra("editTextValue");
                stringAutori= data.getStringArrayExtra("editTextValue");
            }
        }
    }

    public void adaugare(View v) {

        EditText etTitluPub=(EditText) findViewById(R.id.et_titluPub);
        String titluPub=etTitluPub.getText().toString();

        EditText etAnAp=(EditText) findViewById(R.id.et_anAparitie);
        int anAparitie=Integer.parseInt(etAnAp.getText().toString());

        EditText etTip=(EditText) findViewById(R.id.et_tipArticol);
        String tip=etTip.getText().toString();

        EditText etTitluDoc=(EditText) findViewById(R.id.et_titluPub);
        String titluDoc=etTitluDoc.getText().toString();

        Autor autor=new Autor(stringAutori[0], stringAutori[1]);
        autori.add(autor);

        Dao d=new Dao(getApplicationContext());

        int id=d.returnId(nume);

        Referinta referinta=new Referinta(titluPub,anAparitie,tip,titluDoc,autori,1,id);

        if(d.adaugaReferintaPtClasa(referinta)!=0) {
            Context context = getApplicationContext();
            CharSequence text = "S-a adaugat o referinta";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
