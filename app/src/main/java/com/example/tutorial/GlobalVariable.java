package com.example.tutorial;

import android.app.Application;

public class GlobalVariable extends Application {
    private int score;

    public int getVariable() {
        return score;
    }

    public void setVariable(int newNumber) {
        this.score = newNumber;
    }
}
