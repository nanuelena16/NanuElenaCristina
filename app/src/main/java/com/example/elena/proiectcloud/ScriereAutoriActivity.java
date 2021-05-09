package com.example.elena.proiectcloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ScriereAutoriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scriere_autori);
    }

    public void adaugaAutori(View v) {

        EditText eNume=(EditText) findViewById(R.id.et_numeAutor);
        String nume=eNume.getText().toString();

        EditText eEmail=(EditText) findViewById(R.id.et_emailAutor);
        String email=eEmail.getText().toString();

        String[] autor=new String[2];
        autor[0]=nume;
        autor[1]=email;

        Intent intent = new Intent();
        intent.putExtra("editTextValue", autor);
        setResult(RESULT_OK, intent);
        finish();
    }
}
