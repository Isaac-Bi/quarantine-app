package com.example.app;
import java.io.*;
//import Answer;

/**
 * Class to implement a question, with array of associated choices
 */
public class Question {
    private String prompt;
    private Answer[] choices;

    /**
     * Question class constructor
     *
     * @param prompt for question
     * @param choices array of answer choices
     */
    public Question(String prompt, Answer[] choices) {
        this.prompt = prompt;
        this.choices = choices;
    }

    /**
     * Getter method for the prompt
     *
     * @return the prompt of the question
     */
    public String getPrompt() {
        return this.prompt;
    }

    public Answer[] getChoices() {
        return this.choices;
    }
}
