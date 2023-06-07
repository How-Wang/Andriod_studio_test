package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import android.view.animation.Animation;

public class Japan_Fugu_intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_fugu_intro);
        TextView t = (TextView)findViewById(R.id.textView3);
        t.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}