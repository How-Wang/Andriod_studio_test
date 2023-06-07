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

public class main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
    public void IntroIsClicked(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void GameIsClicked(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}