package com.example.quiz1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView namePointTxt;
    private Button registerBtn;
    private String name, score, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namePointTxt = findViewById(R.id.namePointTxt);
        registerBtn = findViewById(R.id.registerBtn);

        list = "Los registrados:\n";

        registerBtn.setOnClickListener(
                (v)->{
                    Intent register = new Intent(this, RegisterActivity.class);
                    startActivity(register);
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("surveys_made", MODE_PRIVATE);
        name = sp.getString("name", "");
        score = sp.getString("score", "");
        list += name + "    " + score + "\n";

        namePointTxt.setText(list);

    }
}