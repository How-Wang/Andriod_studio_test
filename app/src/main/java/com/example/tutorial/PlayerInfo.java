package com.example.tutorial;

public class PlayerInfo {
    static private String account;
    static private String pwd;
    static private int coin;
    static private String name;
    static private String region;
    static private int score;

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
    public static void setRegion(String _region){ region = _region;}
    public static void setScore(int _score) { score = _score;};

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
    public static String getRegion(){ return region;}
    public static int getScore(){return score;};

}
