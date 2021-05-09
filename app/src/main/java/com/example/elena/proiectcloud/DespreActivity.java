package com.example.elena.proiectcloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DespreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despre);
    }

    public void contact(View v) {
        Intent intent=new Intent(this, MapsActivity.class);
        startActivity(intent);

    }
}
