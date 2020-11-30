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

public class SecondQuestion extends AppCompatActivity {

    // Question Label
    private TextView questionTwo;
    //Next Question button
    private Button next2;
    //Number assigned to choice
    private int questionTwoChoice;

    QuestionBank q2 = new QuestionBank();

    Question secondQ;
    ListView lvAnswers2;
    Answer[] answers2;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        secondQ = q2.getQuestionTwo();
        //Sets question
        questionTwo = (TextView) findViewById(R.id.questionTwo);
        questionTwo.setText(secondQ.getPrompt());


        //Listview for question
        lvAnswers2=findViewById(R.id.LVAnswers2);
        answers2 = secondQ.getChoices();

        for(int i =0; i< answers2.length;i++)
        {
            answersStr.add(answers2[i].getContent());
        }

        ArrayAdapter<String> ansAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,answersStr);
        lvAnswers2.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                String response = (String)lvAnswers2.getItemAtPosition(position);
                rScore = answers2[answersStr.indexOf(response)];
                score = rScore.getRiskScore();
                Toast.makeText(getApplicationContext(),"Score "+score,Toast.LENGTH_SHORT).show();
            }
        });

        //Next question button
//        next2 = (Button)findViewById(R.id.nextBtn2);
//        //next question button
//        next2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),ThirdQuestion.class));
//            }
//        });
    }
}