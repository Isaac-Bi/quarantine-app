package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterTestMainMild extends AppCompatActivity {
    private TextView mildText;
    private Button homeBtnMild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_mild);

        mildText = (TextView) findViewById(R.id.mild_circle);
        mildText.setText(String.valueOf(UserData.getInstance().getScore()));

        //Next question button
        homeBtnMild = (Button)findViewById(R.id.mild_retake);
        //next question button
        homeBtnMild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().resetScore();
                startActivity(new Intent(getApplicationContext(),FirstQuestion.class));
            }
        });
    }
}