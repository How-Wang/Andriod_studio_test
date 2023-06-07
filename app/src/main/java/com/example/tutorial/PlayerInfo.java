package com.example.tutorial;

public class PlayerInfo {
    static private String account;
    static private String pwd;
    static private int coin;
    static private String name;

    public static void setAccount(String _account){
        account = _account;
    }
    public static void setPwd(String _pwd){
        pwd = _pwd;
    }
    public static void setCoin (int _coin){
        coin = _coin;
    }
    public static void setName(String _name){
        name = _name;
    }

    public static String getAccount(){
        return account;
    }
    public static String getpwd(){
        return pwd;
    }
    public static int getCoin(){
        return coin;
    }
    public static String getName() {
        return name;
    }

}
