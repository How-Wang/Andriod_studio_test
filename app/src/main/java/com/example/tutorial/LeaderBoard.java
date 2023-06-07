package com.example.tutorial;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LeaderBoard extends AppCompatActivity {
    private SqlDataBaseHelper sqldatabaseHelper;
    private static final String DatabaseName = "DietKing";
    private static final int DatabaseVersion = 1;
    private static String DatabaseTable = "User";
    private static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        sqldatabaseHelper = new SqlDataBaseHelper(this,DatabaseName,null, DatabaseVersion, DatabaseTable);
        ArrayList<HashMap<String,String>> ranks = sqldatabaseHelper.getRank(PlayerInfo.getName(),PlayerInfo.getRegion(),PlayerInfo.getScore());

        String s = Integer.toString(((GlobalVariable) this.getApplication()).getVariable());
        ((TextView)findViewById(R.id.S_textView)).setText(ranks.get(3).get(""));
        // wait for change
        ((TextView)findViewById(R.id.N_textView)).setText("");
        ((TextView)findViewById(R.id.R_textView)).setText("");
        ((TextView)findViewById(R.id.S1_textView)).setText("");
        ((TextView)findViewById(R.id.N1_textView)).setText("");
        ((TextView)findViewById(R.id.S2_textView)).setText("");
        ((TextView)findViewById(R.id.N2_textView)).setText("");
        ((TextView)findViewById(R.id.S3_textView)).setText("");
        ((TextView)findViewById(R.id.N3_textView)).setText("");
    }

    public void HomeClicked(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
