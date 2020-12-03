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

public class FifthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionFive;
    //Next Question button
    private Button next5;
    //Number assigned to choice
    private int questionFiveChoice;

    QuestionBank q5 = new QuestionBank();

    Question fifthQ;
    ListView lvAnswers5;
    Answer[] answers5;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);
        fifthQ = q5.getQuestion(4);
        //Sets question
        questionFive = (TextView) findViewById(R.id.questionFive);
        questionFive.setText(fifthQ.getPrompt());


        //Listview for question
        lvAnswers5=findViewById(R.id.LVAnswers5);
        answers5 = fifthQ.getChoices();
        for(int i =0; i< answers5.length;i++)
        {
            answersStr.add(answers5[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers5);
        lvAnswers5.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers5.getItemAtPosition(position);
                rScore = answers5[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next5 = (Button)findViewById(R.id.nextBtn5);
        //next question button
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),SixthQuestion.class));
            }
        });
    }
}