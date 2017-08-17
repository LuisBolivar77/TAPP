package com.example.luchobolivar.tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }



    public void rutas(View v){

        Intent intent = new Intent(this, RutasActivity.class);
        startActivity(intent);

    }

    public void localizacionRutas(View v){

        Intent intent = new Intent(this, GPSActivity.class);
        startActivity(intent);

    }
}
