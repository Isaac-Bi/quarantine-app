package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EighthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionEight;
    //Next Question button
    private Button next8;
    //Number assigned to choice
    private int questionEightChoice;

    QuestionBank q8 = new QuestionBank();

    Question eighthQ;
    ListView lvAnswers8;
    Answer[] answers8;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_question);
        eighthQ = q8.getQuestion(7);
        //Sets question
        questionEight = (TextView) findViewById(R.id.questionEight);
        questionEight.setText(eighthQ.getPrompt());


        //Listview for question
        lvAnswers8=findViewById(R.id.LVAnswers8);
        answers8 = eighthQ.getChoices();
        for(int i =0; i< answers8.length;i++)
        {
            answersStr.add(answers8[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers8);
        lvAnswers8.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers8.getItemAtPosition(position);
                rScore = answers8[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next8 = (Button)findViewById(R.id.nextBtn8);
        //next question button
        next8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),NinthQuestion.class));
            }
        });
    }
}