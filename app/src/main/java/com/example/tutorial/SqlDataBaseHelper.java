package com.example.tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class SqlDataBaseHelper extends SQLiteOpenHelper {
    private static final String DatabaseName = "DietKing";
    private static final int DatabaseVersion = 1;

    public SqlDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String TableName) {
        super(context, DatabaseName, null, DatabaseVersion);
        Log.d("constructor","cons");

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("create table", " create talbe");
        System.out.println("create table");
        String SqlTableUser = "CREATE TABLE IF NOT EXISTS User("
                + "account TEXT PRIMARY KEY,"
                + "pwd TEXT not null,"
                + "coin INTEGER not null,"
                + "name TEXT not null"
                + ")";
        String SqlTableUnlock = "CREATE TABLE IF NOT EXISTS Unlock("
                + "account TEXT PRIMARY KEY ,"
                + "region TEXT PRIMARY KEY,"
                + "FOREIGN KEY (account) REFERENCES User(account)"
                + ")";
        String SqlTableRank = "CREATE TABLE IF NOT EXISTS Record("
                + "name TEXT PRIMARY KEY,"
                + "region TEXT PRIMARY KEY,"
                + "score int"
                + ")";
        sqLiteDatabase.execSQL(SqlTableUser);
//        sqLiteDatabase.execSQL(SqlTableUnlock);
//        sqLiteDatabase.execSQL(SqlTableRank);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String dropUSERSQL = "DROP TABLE User";
        final String dropUnlockSQL = "DROP TABLE Unlock";
        sqLiteDatabase.execSQL(dropUSERSQL);
        sqLiteDatabase.execSQL(dropUnlockSQL);

    }

    public void checkTable() {
        String TableName = "User";
        Cursor cursor = getWritableDatabase().rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TableName + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                getWritableDatabase().execSQL("CREATE TABLE IF NOT EXiSTS " + TableName + "("
                        + "account TEXT PRIMARY KEY,"
                        + "pwd TEXT not null,"
                        + "coin INTEGER not null,"
                        + "name TEXT not null"
                        + ")") ;
        }
    }

    public ArrayList<String> getTables() {
        Cursor cursor = getWritableDatabase().rawQuery("select * from user", null);
        ArrayList<String> tables = new ArrayList<>();
        while (cursor.moveToNext()) {
            String getTab = new String(cursor.getBlob(0));
            if (getTab.contains("android_metadata")) {
            } else if (getTab.contains("sqlite_sequence")) {
            } else tables.add(getTab.substring(0, getTab.length() - 1));
        }
        return tables;
    }

    public boolean logIn(String account, String pwd){
        String TableName = "user";
        Cursor cursor = getWritableDatabase().rawQuery("SELECT pwd FROM User WHERE account = '"+ account + "'", null);
        Log.d("count " ,String.valueOf(cursor.getCount()));
        cursor.moveToFirst();
        Log.d("pwd", cursor.getString(0));
        if (cursor.getString(0).equals(pwd))
            return true;
        else
            return false;
    }
    public HashMap<String,String> getAccountInfo(String account){
        Cursor cursor = getWritableDatabase().rawQuery("SELECT coin, name FROM User WHERE account = '" + account +  "'", null);
        HashMap<String, String> info = new HashMap<>();
        cursor.moveToFirst();
        info.put("coin", cursor.getString(0));
        info.put("name", String.valueOf(cursor.getInt(1)));
        return info;
    }

    public String signUp(String account, String pwd, int coin, String name){
        String sql = "SELECT * FROM User WHERE account = '" + account +  "'";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0){
            return "account repeat";
        }
        sql = "SELECT * FROM User WHERE name = '" + name +  "'";
        cursor = getWritableDatabase().rawQuery(sql, null);
        if(cursor.getCount() > 0){
            return "name repeat";
        }

        String TableName = "user";
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("account", account);
        values.put("pwd", pwd);
        values.put("coin", coin);
        values.put("name", name);
        db.insert(TableName, null, values);
        return "sign up successfully";
    }

    public ArrayList<HashMap<String, String>> showAll(){
        String TableName = "user";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TableName, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while(c.moveToNext()){
            HashMap<String, String> hashMap = new HashMap<>();

            String account = c.getString(0);
            int coin = c.getInt(2);
            String name = c.getString(3);

            hashMap.put("account", account);
            hashMap.put("coin", String.valueOf(coin));
            hashMap.put("name", name);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public void addRecord(String name, String region, int score){
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM Record WHERE name = '" + name +  "'", null);
        if (cursor.getCount()>0){
//            cursor = getWritableDatabase().rawQuery("UPDATE Record WHERE name = '" + name + "' AND region = '" + region + "'", null);
            ContentValues values = new ContentValues();
            values.put("score",score);
            int count = getWritableDatabase().update("Record", values, " name = '" + name + "' AND region = '" + region + "'", null);
        }
        else {
            String TableName = "Record";
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values =new ContentValues();
            values.put("score", score);
            values.put("region", region);
            values.put("name", name);
            db.insert(TableName, null, values);
        }
    }
    public ArrayList<HashMap<String, String>> getRank(String name, String region, int score){
        Cursor cursor = getWritableDatabase().rawQuery("SELECT name, score, RANK() over (ORDER BY score DESC) RK FROM Record WHERE region '" + region +  "'", null);
        cursor.moveToFirst();
        ArrayList<HashMap<String,String>> ans = new ArrayList<HashMap<String, String>>(4);
        for(int i =0;i <cursor.getCount(); i++){
            if (i <= 2){
                HashMap<String, String> item = new HashMap<String, String>();
                item.put("name", cursor.getString(0));
                item.put("score", String.valueOf(cursor.getInt(1)));
                ans.set(i,item);
            }
            if (cursor.getString(0).equals(name)){
                HashMap<String, String> item = new HashMap<String, String>();
                item.put("name", name);
                item.put("rank", String.valueOf(cursor.getInt(2)));
                item.put(cursor.getString(0), String.valueOf(cursor.getInt(2)));
                ans.set(3,item);
            }
        }
        return ans;

    }
}
