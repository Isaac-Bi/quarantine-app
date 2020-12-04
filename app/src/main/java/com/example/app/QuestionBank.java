package com.example.app;


public class QuestionBank {
    private Answer[] q1Answers = {
            new Answer("Yes", 0),
            new Answer("Only if I know there's people around", 10),
            new Answer("Never", 20)
    };
    private Answer[] q2Answers = {
            new Answer("0", 0),
            new Answer("1", 10),
            new Answer("2 or more", 20)
    };
    private Answer[] q3Answers = {
            new Answer("Yes", 30),
            new Answer("No", 0),
            new Answer("No, attended one with 50 or more", 15)
    };
    private Answer[] q4Answers = {
            new Answer("Yes", 20),
            new Answer("No", 0),
            new Answer("No, but I used something that more than 5 people used", 10)
    };
    private Answer[] q5Answers = {
            new Answer("Yes", 10),
            new Answer("No", 0),
    };
    private Answer[] q6Answers = {
            new Answer("Yes", 0),
            new Answer("No", 10),

    };
    private Answer[] q7Answers = {
            new Answer("Office worker(no customer interaction)", 5),
            new Answer("Remote worker(no contact with others)", 0),
            new Answer("Essential worker(customer interaction)", 20),
            new Answer("Unemployed", 0),
            new Answer("Healthcare worker", 30),
    };
    private Answer[] q8Answers = {
            new Answer("Yes (airplane, bus, train)", 10),
            new Answer("No", 0),

    };
    private Answer[] q9Answers = {
            new Answer("Yes, indoor dining", 20),
            new Answer("Yes, outdoor dining", 10),
            new Answer("No", 0)
    };


    private Question[] questions = {
            new Question("Do you wear a mask each time you head outside?", q1Answers),
            new Question("How many times have you gone shopping in the last two weeks?",q2Answers),
            new Question("Have you attended any event or function with more than 100 people? ",q3Answers),
            new Question("Have you used anything that more than 10 people use (e.g working out at a gym, a swimming pool, amusement park, movie theaters)",q4Answers),
            new Question("Have you stayed overnight outside of your house or your home (e.g. camping, at a friend's or family’s place, a hotel)",q5Answers),
            new Question("Do you wash your hands or sanitize your hands when going out?",q6Answers),
            new Question("Please choose the option that best describes your employment status",q7Answers),
            new Question("Have you ever taken public transit during COVID-19?",q8Answers),
            new Question("Have you eaten out at a restaurant?",q9Answers),


    };

    public Question getQuestion(int idx) {
        return questions[idx];
    }



}
