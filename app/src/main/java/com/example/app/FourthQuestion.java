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

public class FourthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionFour;
    //Next Question button
    private Button next4;
    //Number assigned to choice
    private int questionFourChoice;

    QuestionBank q4 = new QuestionBank();

    Question fourthQ;
    ListView lvAnswers4;
    Answer[] answers4;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);
        fourthQ = q4.getQuestion(3);
        //Sets question
        questionFour = (TextView) findViewById(R.id.questionFour);
        questionFour.setText(fourthQ.getPrompt());


        //Listview for question
        lvAnswers4=findViewById(R.id.LVAnswers4);
        answers4 = fourthQ.getChoices();
        for(int i =0; i< answers4.length;i++)
        {
            answersStr.add(answers4[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers4);
        lvAnswers4.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers4.getItemAtPosition(position);
                rScore = answers4[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next4 = (Button)findViewById(R.id.nextBtn4);
        //next question button
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),FifthQuestion.class));
            }
        });
    }
}