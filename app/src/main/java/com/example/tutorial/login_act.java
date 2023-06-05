package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.ImageView;
import android.view.animation.Animation;

public class login_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void SignupAct(View v){
        TextView t = findViewById(R.id.login_account);
        String loginAC = t.getText().toString();
        Log.d("info", loginAC);

        TextView x = findViewById(R.id.LoginPassword);
        String loginPw = x.getText().toString();
        Log.d("info", loginPw);
        Intent i = new Intent(this, Signup_Act.class);
        startActivity(i);
    }

    public void GetLoginAcc(View v){

    }
}