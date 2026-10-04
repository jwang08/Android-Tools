package com.example.q6;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Calculator calculator;
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //applies button listener
        ButtonHandler buttonHandler = new ButtonHandler();
        appInterface = new AppInterface(this, buttonHandler);
        //sets display to AppInterface java file
        setContentView(appInterface);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        //Checks input using Calculator class
        public void onClick(View v)
        {
            int input = appInterface.getInput();
            calculator = new Calculator(input);

            String out = "Not a prime.";
            if(calculator.isPrime()){
                out = "Is a prime.";
            }
            appInterface.setOutput(out);
        }
    }
}