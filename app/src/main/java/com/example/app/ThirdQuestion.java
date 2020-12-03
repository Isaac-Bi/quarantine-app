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

public class ThirdQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionThree;
    //Next Question button
    private Button next3;
    //Number assigned to choice
    private int questionThreeChoice;

    QuestionBank q3 = new QuestionBank();

    Question thirdQ;
    ListView lvAnswers3;
    Answer[] answers3;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);
        thirdQ = q3.getQuestion(2);
        //Sets question
        questionThree = (TextView) findViewById(R.id.questionThree);
        questionThree.setText(thirdQ.getPrompt());


        //Listview for question
        lvAnswers3=findViewById(R.id.LVAnswers3);
        answers3 = thirdQ.getChoices();
        for(int i =0; i< answers3.length;i++)
        {
            answersStr.add(answers3[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers3);
        lvAnswers3.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers3.getItemAtPosition(position);
                rScore = answers3[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next3 = (Button)findViewById(R.id.nextBtn3);
        //next question button
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                startActivity(new Intent(getApplicationContext(),FourthQuestion.class));
            }
        });
    }
}