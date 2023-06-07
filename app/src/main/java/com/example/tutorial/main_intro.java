package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import android.view.animation.Animation;

public class main_intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);
    }
    public void JapanClicked(View v){
        Intent i = new Intent(this, Japan_into_main.class);
        startActivity(i);
    }
    public void ChinaClicked(View v){
        Intent i = new Intent(this, China_into_main.class);
        startActivity(i);
    }
    public void ItalyClicked(View v){
        Intent i = new Intent(this, Italy_into_main.class);
        startActivity(i);
    }
}