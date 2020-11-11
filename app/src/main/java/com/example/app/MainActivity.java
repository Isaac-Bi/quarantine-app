 package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Directs user to FirstQuestion page
    public void takeQuiz(View view){
        Intent firstQuestionActivity = new Intent(this, FirstQuestion.class);
        startActivity(firstQuestionActivity);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();;
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}