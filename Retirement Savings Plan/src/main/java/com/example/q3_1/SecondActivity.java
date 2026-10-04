package com.example.q3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        updateView();
    }

    private void updateView() {
        //Grabs input values from MainActivity
        Intent intent = getIntent();
        double principal = intent.getDoubleExtra("principal", 0);
        double addition = intent.getDoubleExtra("addition", 0);
        double years = intent.getDoubleExtra("years", 0);
        double rate = intent.getDoubleExtra("rate", 0);
        TextView out = findViewById(R.id.output);

        Calculator calc = new Calculator();

        //Calculates the investment each year and displays it
        String output = "";
        for (int i = 0; i < years; i++){
            calc.set(principal, addition, rate, i);
            output += String.format("%5s%22s\n", i, calc.getTotal());
        }
        calc.set(principal, addition, rate, years);
        output += String.format("%5s%22s", (int)years, calc.getTotal());
        out.setText(output);
    }


    public void back(View view) {
        //Ends activity and goes back to first screen
        finish();
    }
}
