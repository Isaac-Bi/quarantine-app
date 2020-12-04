package com.example.app;

public class UserData {
    private int riskScore;
    public int getScore() {
        return riskScore;
    }

    public void setScore(int factor) {
        this.riskScore += factor;
    }

    public void resetScore() {
        this.riskScore = 0;
    }

    private static final UserData data = new UserData();
    public static UserData getInstance() {
        return data;
    }
}
