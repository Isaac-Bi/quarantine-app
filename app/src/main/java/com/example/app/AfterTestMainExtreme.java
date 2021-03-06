package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterTestMainExtreme extends AppCompatActivity {
    private TextView extremeText;
    private Button homeBtnExtreme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_extreme);

        extremeText = (TextView) findViewById(R.id.extreme_circle);
        extremeText.setText(String.valueOf(UserData.getInstance().getScore()));

        //Next question button
        homeBtnExtreme = (Button)findViewById(R.id.extreme_retake);
        //next question button
        homeBtnExtreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().resetScore();
                startActivity(new Intent(getApplicationContext(),FirstQuestion.class));
            }
        });
    }
}