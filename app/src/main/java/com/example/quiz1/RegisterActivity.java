package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameTxt, codeTxt;
    private Button continueBtn1;
    private String name, code, codeCompare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameTxt = findViewById(R.id.nameTxt);
        codeTxt = findViewById(R.id.codeTxt);
        continueBtn1 = findViewById(R.id.continueBtn1);
        SharedPreferences sp = getSharedPreferences("surveys_made", MODE_PRIVATE);

        continueBtn1.setOnClickListener(
                (v)->{
                    //Assign variable to editText
                    name = nameTxt.getText().toString();
                    code = codeTxt.getText().toString();

                    if (name.isEmpty() || code.isEmpty()){
                        Toast.makeText(this, "Llena los espacios", Toast.LENGTH_SHORT).show();
                    } else {
                        //Add variables to shared preferences
                        sp.edit().putString("name", name).apply();
                        sp.edit().putString("identification", code).apply();

                        if (code == codeCompare){
                            Toast.makeText(this, "Código ya registrado", Toast.LENGTH_SHORT).show();
                        } else {
                            //Start new activity
                            Intent nexus = new Intent(this, PreparationActivity.class);
                            startActivity(nexus);
                            finish();
                        }

                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("surveys_made", MODE_PRIVATE);
        codeCompare = sp.getString("code", "");
    }
}