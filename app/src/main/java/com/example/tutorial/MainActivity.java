package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CountryClicked(View v){
        ImageButton imageButton = findViewById(R.id.China_button);
        CharSequence contentDescription = imageButton.getContentDescription();
        // If needed, convert the content description to a String
        String contentDescriptionString = contentDescription != null ? contentDescription.toString() : "";
        Log.d("20", contentDescriptionString);

        // split string and feed it into Class name to call
        String className = "com.example.tutorial." + contentDescriptionString + "_Game1"; // Replace with the fully qualified class name of China_Game1

        try {
            Class<?> targetClass = Class.forName(className);
            Intent i = new Intent(this, targetClass);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}