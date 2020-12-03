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

public class TenthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionTen;
    //Next Question button
    private Button next10;
    //Number assigned to choice
    private int questionTenChoice;

    QuestionBank q10 = new QuestionBank();

    Question tenthQ;
    ListView lvAnswers10;
    Answer[] answers10;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_question);
        tenthQ = q10.getQuestion(9);
        //Sets question
        questionTen = (TextView) findViewById(R.id.questionTen);
        questionTen.setText(tenthQ.getPrompt());


        //Listview for question
        lvAnswers10=findViewById(R.id.LVAnswers10);
        answers10 = tenthQ.getChoices();
        for(int i =0; i< answers10.length;i++)
        {
            answersStr.add(answers10[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers10);
        lvAnswers10.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers10.getItemAtPosition(position);
                rScore = answers10[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next10 = (Button)findViewById(R.id.nextBtn10);
        //next question button
        next10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().setScore(score);
                if((UserData.getInstance().getScore() >= 0) && (UserData.getInstance().getScore() <= 10)){
                    startActivity(new Intent(getApplicationContext(),AfterTestMainLow.class));
                }
                else if((UserData.getInstance().getScore() >= 11)&&(UserData.getInstance().getScore() <= 20))
                {
                    startActivity(new Intent(getApplicationContext(),AfterTestMainMild.class));
                }
                else if((UserData.getInstance().getScore() >= 21) && (UserData.getInstance().getScore() <= 30))
                {
                    startActivity(new Intent(getApplicationContext(),AfterTestMainModerate.class));
                }
                else if((UserData.getInstance().getScore() >= 31) && (UserData.getInstance().getScore() <= 40))
                {
                    startActivity(new Intent(getApplicationContext(),AfterTestMainHigh.class));
                }
                else if((UserData.getInstance().getScore() >= 41) && (UserData.getInstance().getScore() <= 50))
                {
                    startActivity(new Intent(getApplicationContext(),AfterTestMainExtreme.class));
                }

            }
        });
    }
}