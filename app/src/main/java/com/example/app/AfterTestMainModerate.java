package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterTestMainModerate extends AppCompatActivity {
    private TextView moderateText;
    private Button homeBtnModerate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_moderate);

        moderateText = (TextView) findViewById(R.id.moderate_circle);
        moderateText.setText(String.valueOf(UserData.getInstance().getScore()));

        //Next question button
        homeBtnModerate = (Button)findViewById(R.id.moderate_retake);
        //next question button
        homeBtnModerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.getInstance().resetScore();
                startActivity(new Intent(getApplicationContext(),FirstQuestion.class));
            }
        });
    }
}