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

import java.util.HashMap;

public class login_act extends AppCompatActivity {
    private SqlDataBaseHelper sqldatabaseHelper;
    private static final String DatabaseName = "DietKing";
    private static final int DatabaseVersion = 1;
    private static String DatabaseTable = "User";
    private static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqldatabaseHelper = new SqlDataBaseHelper(this, DatabaseName, null, DatabaseVersion, DatabaseTable);


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
    public void loginAct(View v){
        TextView t = findViewById(R.id.login_account);
        String loginAC = t.getText().toString();
        Log.d("login_info", loginAC);

        TextView x = findViewById(R.id.LoginPassword);
        String loginPw = x.getText().toString();
        Log.d("login_info", loginPw);
//        loginAC = 登入帳號
//        loginPW = 登入密碼
        boolean isLogin = sqldatabaseHelper.logIn(loginAC,loginPw);
        if(isLogin) {
            HashMap<String,String> info = sqldatabaseHelper.getAccountInfo(loginAC);
            PlayerInfo.setCoin(Integer.parseInt(info.get("coin")));
            PlayerInfo.setName(info.get("name"));
            Log.d("playerName" , info.get("name"));
            PlayerInfo.setAccount(loginAC);
            Toast.makeText(getApplicationContext(), "登入成功", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, main_page.class);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "登入失敗", Toast.LENGTH_SHORT).show();
        }
//        if(帳號密碼符合){
//            Intent i = new Intent(this, 登入完要跳轉的頁面，我暫時設王浩題目的那頁，註解掉最下面兩行);
//            startActivity(i);
//        }
        /*Toast.makeText(getApplicationContext(), "登入成功", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);*/
    }
}