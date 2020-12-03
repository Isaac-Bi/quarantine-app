package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FirstQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionOne;
    //Next Question button
    private Button next1;
    //Number assigned to choice
    private int questionOneChoice;

    QuestionBank q1 = new QuestionBank();

    Question firstQ;
    ListView lvAnswers1;
    Answer[] answers1;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        firstQ = q1.getQuestion(0);
        //Sets question
        questionOne = (TextView) findViewById(R.id.questionOne);
        questionOne.setText(firstQ.getPrompt());


        //Listview for question
        lvAnswers1=findViewById(R.id.LVAnswers1);
        answers1 = firstQ.getChoices();

        for(int i =0; i< answers1.length;i++)
        {
            answersStr.add(answers1[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers1);

        lvAnswers1.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer) lvAnswers1.getItemAtPosition(position);
                rScore = answers1[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

                // Toast.makeText(getApplicationContext(),"Score "+score,Toast.LENGTH_SHORT).show();
            }
        });

        //Next question button
        next1 = (Button)findViewById(R.id.nextBtn1);
        //next question button
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),SecondQuestion.class));
            }
        });
    }

}