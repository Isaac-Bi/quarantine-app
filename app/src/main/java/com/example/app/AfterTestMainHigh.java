package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterTestMainHigh extends AppCompatActivity {
    private TextView highText;
    private Button homeBtnHigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_high);

        highText = (TextView) findViewById(R.id.high_circle);
        highText.setText(String.valueOf(UserData.getInstance().getScore()));

        //Next question button
        homeBtnHigh = (Button)findViewById(R.id.high_retake);
        //next question button
        homeBtnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().resetScore();
                startActivity(new Intent(getApplicationContext(),FirstQuestion.class));
            }
        });
    }
}