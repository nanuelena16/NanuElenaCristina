package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logare);

        preferinte();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String nume=getResources().getString(R.string.prefNume);
        String parola=getResources().getString(R.string.prefParola);

        EditText etNume = (EditText)findViewById(R.id.et_numecont);
        EditText etParola=(EditText)findViewById(R.id.et_parola);

        etNume.setText(nume);
        etParola.setText(parola);
    }

    public void conectare(View v) {
        Dao dao=new Dao(getApplicationContext());

        //User user1=new User(1,"aaa","aaa");
        //dao.adaugaUserPtClasa(user1);

        EditText etNume = (EditText)findViewById(R.id.et_numecont);
        EditText etParola=(EditText)findViewById(R.id.et_parola);

        String nume=etNume.getText().toString();
        String parola=etParola.getText().toString();

        User userCurent=new User(nume,parola);

        if(dao.existaUser(userCurent)==1) {
            Intent intent=new Intent(this,PagPrincipalaActivity.class);
            intent.putExtra("a",nume);

            startActivity(intent);


            Context context = getApplicationContext();
            CharSequence text = "Conectare cu succes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "User incorect";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void creareCont(View v) {
        Intent intent=new Intent(this, CreareUserActivity.class);
        startActivity(intent);
    }

    public void preferinte() {
        EditText etNume = (EditText)findViewById(R.id.et_numecont);
        EditText etParola=(EditText)findViewById(R.id.et_parola);

        String nume=etNume.getText().toString();
        String parola=etParola.getText().toString();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.prefNume), nume);
        editor.putString(getString(R.string.prefParola), parola);
        editor.commit();
    }
}
