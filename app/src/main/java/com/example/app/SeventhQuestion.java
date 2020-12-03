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

public class SeventhQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionSeven;
    //Next Question button
    private Button next7;
    //Number assigned to choice
    private int questionSevenChoice;

    QuestionBank q7 = new QuestionBank();

    Question seventhQ;
    ListView lvAnswers7;
    Answer[] answers7;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_question);
        seventhQ = q7.getQuestion(6);
        //Sets question
        questionSeven = (TextView) findViewById(R.id.questionSeven);
        questionSeven.setText(seventhQ.getPrompt());


        //Listview for question
        lvAnswers7=findViewById(R.id.LVAnswers7);
        answers7 = seventhQ.getChoices();
        for(int i =0; i< answers7.length;i++)
        {
            answersStr.add(answers7[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers7);
        lvAnswers7.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers7.getItemAtPosition(position);
                rScore = answers7[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next7 = (Button)findViewById(R.id.nextBtn7);
        //next question button
        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),EighthQuestion.class));
            }
        });
    }
}