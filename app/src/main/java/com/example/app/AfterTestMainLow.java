package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterTestMainLow extends AppCompatActivity {
    private TextView lowText;
    private Button homeBtnLow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_low);

        lowText = (TextView) findViewById(R.id.low_circle);
        lowText.setText(String.valueOf(UserData.getInstance().getScore()));

        //Next question button
        homeBtnLow = (Button)findViewById(R.id.low_retake);
        //next question button
        homeBtnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().resetScore();
                startActivity(new Intent(getApplicationContext(),FirstQuestion.class));
            }
        });
    }
}