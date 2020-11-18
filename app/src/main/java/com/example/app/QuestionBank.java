package com.example.app;

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
                    "Chronic kidney disease, COPD (chronic obstructive pulmonary disease), " +
                    "obesity (BMI >= 30), immunocompromised state, heart conditions (e.g., " +
                    "heart failure, cardiomyopathies), sickle cell disease, type 2 diabetes",
                    q2Answers
            )
    };

    public Question getQuestionOne ()
    {
        return questions[0];
    }

    public Question getQuestionTwo () {return questions[1];}

}
