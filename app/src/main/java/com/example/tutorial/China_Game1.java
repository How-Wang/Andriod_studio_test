package com.example.tutorial;
//mergetest
//branch test
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
public class China_Game1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_game1);

        String s = Integer.toString(((GlobalVariable) this.getApplication()).getVariable());
        ((TextView)findViewById(R.id.Score_textview)).setText(s);
    }

    public void CorrectClicked(View v){

    }
    public void WrongClicked(View v){
//        ImageView checkMarkImageView = findViewById(R.id.check_mark);
//        Animation checkMarkAnimation = AnimationUtils.loadAnimation(this, R.anim.check_mark_animation);
//        checkMarkImageView.startAnimation(checkMarkAnimation);

        Intent i = new Intent(this, China_Game2.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
