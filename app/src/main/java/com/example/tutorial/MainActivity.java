package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((GlobalVariable) this.getApplication()).setVariable(0);

    }
    public void CountryClicked(View v){

            ImageButton imageButton = (ImageButton) v;
            // mageButton imageButton = findViewById(R.id.China_button);
            CharSequence contentDescription = imageButton.getContentDescription();

            // If needed, convert the content description to a String
            String contentDescriptionString = contentDescription != null ? contentDescription.toString() : "";
            PlayerInfo.setRegion(contentDescriptionString);
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
    public void loginClicked(View v){
        //launch login
        Intent i = new Intent(this, login_act.class);
        startActivity(i);
    }
}