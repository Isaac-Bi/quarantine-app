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
    String [] answersStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        //Sets question
        questionOne = (TextView) findViewById(R.id.questionOne);
        questionOne.setText(firstQ.getPrompt());


        //Listview for question 
        firstQ = q1.getQuestionOne();
        lvAnswers1=findViewById(R.id.LVAnswers1);
        answers1 = firstQ.getChoices();
        answersStr = new String[this.answers1.length];
        for(int i =0; i< answers1.length;i++){
            answersStr[i]=answers1[i].getContent();
        }
        ArrayAdapter<String> ansAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,answersStr);
        lvAnswers1.setAdapter(ansAdapter);

        //Listener for answer button
        lvAnswers1.setOnItemClickListener(new  android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Answer response = (Answer)parent.getItemAtPosition(position);
                int res = response.getRiskScore();
                Toast.makeText(getApplicationContext(),"Clicked"+res,Toast.LENGTH_SHORT).show();

            }
        });

        //Next question button
        next1 = (Button)findViewById(R.id.nextBtn1);
        //next question button
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondQuestion.class));
            }
        });
    }

}