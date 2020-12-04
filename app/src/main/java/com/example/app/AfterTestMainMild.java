package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterTestMainMild extends AppCompatActivity {
    private TextView mildText;
    private Button homeBtnMild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test_main_mild);

        mildText = (TextView) findViewById(R.id.mildText);
        mildText.setText(UserData.getInstance().getScore());

        //Next question button
        homeBtnMild = (Button)findViewById(R.id.homeBtnMild);
        //next question button
        homeBtnMild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}