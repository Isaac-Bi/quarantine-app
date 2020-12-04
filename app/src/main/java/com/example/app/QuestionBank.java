package com.example.app;
//import Answer;
//import Question;

public class QuestionBank {
    private Answer[] q1Answers = {
            new Answer("Always", 0),
            new Answer("Only in crowded situations", 5),
            new Answer("Never", 10)
    };
    private Answer[] q2Answers = {
            new Answer("Yes", 10),
            new Answer("No", 0),
            new Answer("Unsure", 2)
    };

    private Question[] questions = {
            new Question("Do you wear a mask each time you head outside?", q1Answers),
            new Question("Do you have any of the following medical conditions: " +
                    "Chronic kidney disease, chronic obstructive pulmonary disease, " +
                    "obesity, immunocompromised state, heart conditions, sickle cell, type 2 diabetes",
                    q2Answers
            )
    };

    public Question getQuestion(int idx) {
        return questions[idx];
    }



}
