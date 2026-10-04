package com.example.q3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void compute(View view) {
        EditText principalText = findViewById(R.id.principalInput);
        EditText additionText = findViewById(R.id.additionInput);
        EditText yearsText = findViewById(R.id.yearInput);
        EditText rateText = findViewById(R.id.rateInput);

        //Grabs input
        double principal = Integer.parseInt(principalText.getText().toString());
        double addition = Integer.parseInt(additionText.getText().toString());
        double years = Integer.parseInt(yearsText.getText().toString());
        double rate = Integer.parseInt(rateText.getText().toString());

        //Sends input values to secondActivity
        Intent secondActivity = new Intent(this, SecondActivity.class);

        secondActivity.putExtra("principal", principal);
        secondActivity.putExtra("addition", addition);
        secondActivity.putExtra("years", years);
        secondActivity.putExtra("rate", rate);

        startActivity(secondActivity);
    }
}