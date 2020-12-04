package com.example.app;

public class UserData {
    private int riskScore;
    public int getScore() {
        return riskScore;
    }

    public void setScore(int factor) {
        this.riskScore += factor;
        System.out.println(riskScore);
    }

    private static final UserData data = new UserData();
    public static UserData getInstance() {
        return data;
    }
}
