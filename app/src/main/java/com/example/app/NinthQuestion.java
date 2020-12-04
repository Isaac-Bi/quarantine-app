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

public class NinthQuestion extends AppCompatActivity {
    // Question Label
    private TextView questionNine;
    //Next Question button
    private Button next9;
    //Number assigned to choice
    private int questionNineChoice;

    QuestionBank q9 = new QuestionBank();

    Question ninthQ;
    ListView lvAnswers9;
    Answer[] answers9;
    ArrayList<String> answersStr = new ArrayList<String>();
    Answer rScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_question);
        ninthQ = q9.getQuestion(8);
        //Sets question
        questionNine = (TextView) findViewById(R.id.questionNine);
        questionNine.setText(ninthQ.getPrompt());


        //Listview for question
        lvAnswers9=findViewById(R.id.LVAnswers9);
        answers9 = ninthQ.getChoices();
        for(int i =0; i< answers9.length;i++)
        {
            answersStr.add(answers9[i].getContent());
        }
        AnswerArrayAdapter ansAdapter = new AnswerArrayAdapter(this, android.R.layout.simple_list_item_1, answers9);
        lvAnswers9.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, final int position, long id) {
                Answer response = (Answer)lvAnswers9.getItemAtPosition(position);
                rScore = answers9[answersStr.indexOf(response.getContent())];
                score = rScore.getRiskScore();

            }
        });

        //Next question button
        next9 = (Button)findViewById(R.id.nextBtn9);
        //next question button
        next9.setOnClickListener(new View.OnClickListener() {
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