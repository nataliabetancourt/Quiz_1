package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PreparationActivity extends AppCompatActivity {

    private CheckBox checkActivity1, checkActivity2, checkActivity3;
    private Button continueBtn2;
    private int score1, score2, activityScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);

        checkActivity1 = (CheckBox) findViewById(R.id.checkActivity1);
        checkActivity2 = (CheckBox) findViewById(R.id.checkActivity2);
        checkActivity3 = (CheckBox) findViewById(R.id.checkActivity3);
        continueBtn2 = findViewById(R.id.continueBtn2);

        //Button invisible
        continueBtn2.setVisibility(View.GONE);

        //Checking the boxes
        checkActivity1.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkActivity1.isChecked()){
                        score1 = 1;
                        continueBtn2.setVisibility(View.VISIBLE);
                    } else {
                        score1 = 0;
                        continueBtn2.setVisibility(View.GONE);
                    }
                }
        );
        checkActivity2.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkActivity2.isChecked()){
                        score2 = 3;
                        continueBtn2.setVisibility(View.VISIBLE);
                    } else {
                        score2 = 0;
                        continueBtn2.setVisibility(View.GONE);
                    }
                }
        );
        checkActivity3.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkActivity3.isChecked()){
                        continueBtn2.setVisibility(View.VISIBLE);
                    } else {
                        continueBtn2.setVisibility(View.GONE);
                    }
                }
        );


        //Button
        continueBtn2.setOnClickListener(
                (v)->{
                    //Add up each checkbox score
                    activityScore = score1 + score2;

                    //Switch to another screen
                    Intent evaluation = new Intent(this, EvaluationActivity.class);
                    evaluation.putExtra("activityScore", activityScore);
                    startActivity(evaluation);
                    finish();
                }
        );
    }


}