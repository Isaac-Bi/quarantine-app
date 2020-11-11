package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionOne;
    //Three choices
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button next1;
    //Number assigned to choice
    private int questionOneChoice;

    //Returns number assigned to each choice
    public int getQuestionOneChoice(){
        return questionOneChoice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        questionOne = (TextView)findViewById(R.id.questionOne);
        //Buttons for answer and next question
        answer1 = (Button)findViewById(R.id.answerBtn1);
        answer2 = (Button)findViewById(R.id.answerBtn2);
        answer3 = (Button)findViewById(R.id.answerBtn3);
        next1 = (Button)findViewById(R.id.nextBtn1);


        //listeners for each button
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionOneChoice=2;
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionOneChoice=1;
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionOneChoice=0;
            }
        });

        //next question button
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondQuestion.class));
            }
        });
    }
}