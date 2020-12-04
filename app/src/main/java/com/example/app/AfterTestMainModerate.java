package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterTestMainModerate extends AppCompatActivity {
    private TextView moderateText;
    private Button homeBtnModerate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_moderate);

        moderateText = (TextView) findViewById(R.id.moderateText);
        moderateText.setText(UserData.getInstance().getScore());

        //Next question button
        homeBtnModerate = (Button)findViewById(R.id.homeBtnModerate);
        //next question button
        homeBtnModerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}