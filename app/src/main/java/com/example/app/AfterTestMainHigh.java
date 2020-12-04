package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterTestMainHigh extends AppCompatActivity {
    private TextView highText;
    private Button homeBtnHigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_high);

        highText = (TextView) findViewById(R.id.extremeText);
        highText.setText(UserData.getInstance().getScore());

        //Next question button
        homeBtnHigh = (Button)findViewById(R.id.homeBtnHigh);
        //next question button
        homeBtnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}