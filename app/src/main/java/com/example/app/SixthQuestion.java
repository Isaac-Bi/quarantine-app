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

public class SixthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionSix;
    //Next Question button
    private Button next6;
    //Number assigned to choice
    private int questionSixChoice;

    QuestionBank q6 = new QuestionBank();

    Question sixthQ;
    ListView lvAnswers6;
    Answer[] answers6;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_question);
        sixthQ = q6.getQuestion(5);
        //Sets question
        questionSix = (TextView) findViewById(R.id.questionSix);
        questionSix.setText(sixthQ.getPrompt());


        //Listview for question
        lvAnswers6=findViewById(R.id.LVAnswers6);
        answers6 = sixthQ.getChoices();
        for(int i =0; i< answers6.length;i++)
        {
            answersStr.add(answers6[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers6);
        lvAnswers6.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers6.getItemAtPosition(position);
                rScore = answers6[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next6 = (Button)findViewById(R.id.nextBtn6);
        //next question button
        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),SeventhQuestion.class));
            }
        });
    }
}