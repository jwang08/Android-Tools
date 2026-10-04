package com.example.q32;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private University uni = MainActivity.uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        updateView();
    }

    private void updateView() {
        //Updates the edit box if there was an input previously
        EditText output = findViewById(R.id.creditInput);
        output.setText(String.valueOf(uni.getCredits()));
    }

    public void next(View view) {
        //Saves inputs and goes to third screen
        EditText input = findViewById(R.id.creditInput);
        uni.setCredits(Integer.parseInt(input.getText().toString()));
        Intent thirdAct = new Intent(this, ThirdActivity.class);
        startActivity(thirdAct);
    }
    public void back(View view) {
        //Saves inputs and goes back to first screen
        EditText input = findViewById(R.id.creditInput);
        uni.setCredits(Integer.parseInt(input.getText().toString()));
        finish();
    }
}