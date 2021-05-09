package com.example.elena.proiectcloud;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreareUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_user);
    }

    public void creareContNou(View v) {
        Dao dao=new Dao(getApplicationContext());

        EditText etNume = (EditText)findViewById(R.id.et_crearenume);
        EditText etParola=(EditText)findViewById(R.id.et_creareparola);
       // EditText etId=(EditText)findViewById(R.id.et_creareid);

        String nume=etNume.getText().toString();
        String parola=etParola.getText().toString();
        //int id=Integer.parseInt(etId.getText().toString());

        User user=new User(nume, parola);

        if(dao.existaUser(user)==0) {
            dao.adaugaUserPtClasa(user);

            Context context=getApplicationContext();
            CharSequence text="Cont creat";
            int duration=Toast.LENGTH_SHORT;

            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

            finish();
        } else {
            Context context=getApplicationContext();
            CharSequence text="Exista un astfel de user";
            int duration= Toast.LENGTH_SHORT;

            Toast toast= Toast.makeText(context,text,duration);
            toast.show();

        }


    }
}
