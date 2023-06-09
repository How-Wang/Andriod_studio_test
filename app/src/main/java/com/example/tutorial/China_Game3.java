package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class China_Game3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_game3);

        String s = Integer.toString(((GlobalVariable) this.getApplication()).getVariable());
        ((TextView)findViewById(R.id.Score_textview)).setText(s);
    }

    public void CorrectClicked(View v){
        Button btn = (Button) v;
        btn.setEnabled(false);

        ImageView checkMarkImageView = findViewById(R.id.check_mark_imageview);
        checkMarkImageView.setVisibility(View.VISIBLE);

        Integer score = ((GlobalVariable) this.getApplication()).getVariable();
        score = score + 20;
        ((GlobalVariable) this.getApplication()).setVariable(score);

        String s = Integer.toString(((GlobalVariable) this.getApplication()).getVariable());
        ((TextView)findViewById(R.id.Score_textview)).setText(s);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity here
                startActivity(new Intent(China_Game3.this, China_Game4.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }, 2000);  // 2000 milliseconds = 2 seconds
    }
    public void WrongClicked(View v){

        ImageView checkMarkImageView = findViewById(R.id.cross_mark_imageview);
        checkMarkImageView.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity here
                startActivity(new Intent(China_Game3.this, China_Game4.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }, 2000);  // 2000 milliseconds = 2 seconds

//        Intent i = new Intent(this, China_Game2.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
