package com.example.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //applies butten listener
        Button button = findViewById(R.id.calculate);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    //Grabs inputs and calculates total cost using Calculator function on click
    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            EditText priceText = findViewById(R.id.priceInput);
            ToggleButton warrantyBox = findViewById(R.id.warrantyInput);
            Switch InsuranceSwitch = findViewById(R.id.insuranceInput);
            Spinner deliverySpinner = findViewById(R.id.deliveryInput);

            //input conversion and calculations
            float price = Float.parseFloat(priceText.getText().toString());
            Calculator calc = new Calculator(price, warrantyBox.isChecked(), InsuranceSwitch.isChecked(), deliverySpinner.getSelectedItem().toString());

            //displays output
            TextView out = findViewById(R.id.output);
            out.setText(String.valueOf(calc.getTotal()));
        }
    }
}