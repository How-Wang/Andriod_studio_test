package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.widget.ImageView;
import android.view.animation.Animation;

import java.util.ArrayList;

public class Signup_Act extends AppCompatActivity {
    private SqlDataBaseHelper sqldatabaseHelper;
    private static final String DatabaseName = "DietKing";
    private static final int DatabaseVersion = 1;
    private static String DatabaseTable = "User";
    private static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sqldatabaseHelper = new SqlDataBaseHelper(this,DatabaseName,null, DatabaseVersion, DatabaseTable);
    }
    public void Goback(View v){
        Intent i = new Intent(this, login_act.class);
        startActivity(i);
    }
    public void signupClicked(View v){
        TextView t = findViewById(R.id.SignupAccount);
        String signupAC = t.getText().toString();
        Log.d("signup_info", signupAC);

        TextView x = findViewById(R.id.SignupPassword);
        String signupPw = x.getText().toString();
        Log.d("signup_info", signupPw);

        TextView c = findViewById(R.id.SignupName);
        String signupName = c.getText().toString();
        Log.d("signup_info", signupName);
        if (signupAC.equals("")){
            Toast.makeText(getApplicationContext(), "帳號不可為空", Toast.LENGTH_SHORT).show();
        }
        else if (signupName.equals("")){
            Toast.makeText(getApplicationContext(), "名稱不可為空", Toast.LENGTH_SHORT).show();
        }
        else if (signupPw.equals("")){
            Toast.makeText(getApplicationContext(), "密碼不可為空", Toast.LENGTH_SHORT).show();
        }
        else {
            String s = sqldatabaseHelper.signUp(signupAC,signupPw,0, signupName);
            if (s.equals("account repeat")){
                Toast.makeText(getApplicationContext(), "帳號重複，請更改", Toast.LENGTH_SHORT).show();

            }
            else if (s.equals("name repeat")){
                Toast.makeText(getApplicationContext(), "暱稱重複，請更改", Toast.LENGTH_SHORT).show();
            }
            else if(s.equals("sign up successfully")){
                ArrayList<String> tables = sqldatabaseHelper.getTables();
                //sqldatabaseHelper.addData(signupAC,signupPw,0,"Charles"); // TODO : change name
                for(String st: tables) {
                    System.out.println(st);
                }
                Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, login_act.class);
                startActivity(i);
            }
        }
//        signupAC = 註冊帳號
//        signupPW = 註冊密碼
//        signupName = 註冊暱稱
//        if(帳號註冊過){//不一定要 看你
//            Toast.makeText(getApplicationContext(), "帳號名已註冊", Toast.LENGTH_SHORT).show();
//        }
        /*ArrayList<String> tables = sqldatabaseHelper.getTables();
        //sqldatabaseHelper.addData(signupAC,signupPw,0,"Charles"); // TODO : change name
        for(String s: tables) {
            System.out.println(s);
        }
        Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, login_act.class);
        startActivity(i);*/


    }
}