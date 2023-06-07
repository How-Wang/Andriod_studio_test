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

public class Japan_into_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_into_main);
    }
    public void FuguClicked(View v){
        Intent i = new Intent(this, Japan_Fugu_intro.class);
        startActivity(i);
    }
    public void UnagiClicked(View v){
        Intent i = new Intent(this, Japan_unagi_intro.class);
        startActivity(i);
    }
    public void SashimiClicked(View v){
        Intent i = new Intent(this, Japan_sashimi_intro.class);
        startActivity(i);
    }
}