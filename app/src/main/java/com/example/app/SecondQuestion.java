package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionTwo;
    //Three choices
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button next1;
    //Number assigned to choice
    private int questionTwoChoice;

    //Returns number assigned to each choice
    public int getQuestionTwoChoice(){
        return questionTwoChoice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        questionTwo = (TextView)findViewById(R.id.questionTwo);
        //Buttons for answer and next question
        answer1 = (Button)findViewById(R.id.answerBtn1);
        answer2 = (Button)findViewById(R.id.answerBtn2);
        answer3 = (Button)findViewById(R.id.answerBtn3);
        next1 = (Button)findViewById(R.id.nextBtn1);


        //listeners for each button
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionTwoChoice=2;
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionTwoChoice=1;
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionTwoChoice=0;
            }
        });

        //next question button
//        next1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),ThirdQuestion.class));
//            }
//        });
    }
}