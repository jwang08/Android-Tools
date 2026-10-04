package com.example.q4;

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

    //calculates the output based on what button was pressed and the Calculator class
    public void calculate(View view) {
        EditText inputText = findViewById(R.id.input);
        TextView output = findViewById(R.id.output);
        String input = inputText.getText().toString();
        Calculator calc = new Calculator(input);

        double total = 0;

        //Calculation is picked via button called id
        if(view.getId() == R.id.sum){
            total = calc.getSum();
        }else if (view.getId() == R.id.mean){
            total = calc.getMean();
        }else if (view.getId() == R.id.median){
            total = calc.getMedian();
        }else if (view.getId() == R.id.stdv){
            total = calc.getSTDV();
        }else if (view.getId() == R.id.min){
            total = calc.getMin();
        }else if (view.getId() == R.id.max){
            total = calc.getMax();
        }

        //Rounds to two decimal places and displays output
        output.setText(String.valueOf(Math.round(total * 100.0) / 100.0));
    }
}