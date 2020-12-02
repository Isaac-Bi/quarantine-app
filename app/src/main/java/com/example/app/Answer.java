package com.example.app;


/**
 * Class to implement individual answer choice, with associated risk score
 */
public class Answer {
    private String content;
    private int riskScore;

    /**
     * Answer class constructor
     *
     * @param content of answer
     * @param riskScore associated risk score
     */
    public Answer(String content, int riskScore) {
        this.content = content;
        this.riskScore = riskScore;
    }

    /**
     * Getter method for answer content
     *
     * @return answer content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Getter method for risk score
     *
     * @return risk score
     */
    public int getRiskScore() {
        return this.riskScore;
    }

    /**
     * Updates the risk score
     *
     * @param factor amount by which to update the risk factor, depending on the answer
     */
    public void updateRiskScore(int factor) {
        this.riskScore += factor;
    }
}
