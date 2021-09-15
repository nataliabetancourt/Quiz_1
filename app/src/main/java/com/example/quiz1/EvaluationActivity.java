package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EvaluationActivity extends AppCompatActivity {

    private CheckBox checkEvaluation1, checkEvaluation2, checkEvaluation3;
    private Button finishBtn;
    private int score1, score2, evaluationScore, activityScore, finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        checkEvaluation1 = (CheckBox) findViewById(R.id.checkEvaluation1);
        checkEvaluation2 = (CheckBox) findViewById(R.id.checkEvaluation2);
        checkEvaluation3 = (CheckBox) findViewById(R.id.checkEvaluation3);
        finishBtn = findViewById(R.id.finishBtn);

        //Making button invisible to start with
        finishBtn.setVisibility(View.GONE);

        //Receiving previous score
        activityScore = getIntent().getExtras().getInt("activityScore");

        //Checking the boxes
        checkEvaluation1.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkEvaluation1.isChecked()){
                        score1 = 3;
                        finishBtn.setVisibility(View.VISIBLE);
                    } else {
                        score1 = 0;
                        finishBtn.setVisibility(View.GONE);
                    }
                }
        );
        checkEvaluation2.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkEvaluation2.isChecked()){
                        score2 = 3;
                        finishBtn.setVisibility(View.VISIBLE);
                    } else {
                        score2 = 0;
                        finishBtn.setVisibility(View.GONE);
                    }
                }
        );
        checkEvaluation3.setOnCheckedChangeListener(
                (c, b) -> {
                    if (checkEvaluation3.isChecked()){
                        finishBtn.setVisibility(View.VISIBLE);
                    } else {
                        finishBtn.setVisibility(View.GONE);
                    }
                }
        );


        //Button
        finishBtn.setOnClickListener(
                (v) -> {
                    //Adding scores
                    evaluationScore = score1 + score2;
                    finalScore = evaluationScore + activityScore;

                    //Add score to shared preferences
                    SharedPreferences sp = getSharedPreferences("surveys_made", MODE_PRIVATE);
                    sp.edit().putString("score", "" + finalScore).apply();
                    Toast.makeText(this, "" + finalScore, Toast.LENGTH_SHORT).show();

                    //Finish activity
                    finish();
                }
        );

    }
}