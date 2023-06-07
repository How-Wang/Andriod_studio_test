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

public class Italy_into_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italy_into_main);
    }
    public void btn1(View v){
        Intent i = new Intent(this, Italy_intro1.class);
        startActivity(i);
    }
    public void btn2(View v){
        Intent i = new Intent(this, Italy_intro2.class);
        startActivity(i);
    }
    public void btn3(View v){
        Intent i = new Intent(this, Italy_intro3.class);
        startActivity(i);
    }
    public void btn4(View v){
        Intent i = new Intent(this, Italy_intro4.class);
        startActivity(i);
    }
}