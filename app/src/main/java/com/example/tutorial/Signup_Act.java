package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.widget.ImageView;
import android.view.animation.Animation;

public class Signup_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void signupClicked(View v){
        TextView t = findViewById(R.id.SignupAccount);
        String signupAC = t.getText().toString();
        Log.d("signup_info", signupAC);

        TextView x = findViewById(R.id.SignupPassword);
        String signupPw = x.getText().toString();
        Log.d("signup_info", signupPw);

//        if(帳號註冊過){//提示訊息
//            Toast.makeText(getApplicationContext(), "帳號已註冊", Toast.LENGTH_SHORT).show();
//        }
        Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, login_act.class);
        startActivity(i);
    }
}