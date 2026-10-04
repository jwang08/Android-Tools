package com.example.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implements button listener
        Button button = findViewById(R.id.calculate);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    //Grabs the input values and calculates the grade use the Calculator class when button is clicked
    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            EditText assignText = findViewById(R.id.programInput);
            EditText midText = findViewById(R.id.midInput);
            EditText finalText = findViewById(R.id.finalInput);

            int assignment = 0;
            int mid = 0;
            int finals = 0;
            boolean error = false;

            //Error Checking with toast pop up
            try {
                assignment = Integer.parseInt(assignText.getText().toString());
                if(assignment < 0 || assignment > 200){
                    throw new Exception();
                }
            }catch (Exception e){
                displayError("invalid assignment");
                error = true;
            }
            try {
                mid = Integer.parseInt(midText.getText().toString());
                if(mid < 0 || mid > 100){
                    throw new Exception();
                }
            }catch (Exception e){
                displayError("invalid midterm");
                error = true;
            }
            try {
                finals = Integer.parseInt(finalText.getText().toString());
                if(finals < 0 || finals > 100){
                    throw new Exception();
                }
            }catch (Exception e){
                displayError("invalid final");
                error = true;
            }

            TextView gradeOut = findViewById(R.id.scoreOut);
            TextView letterOut = findViewById(R.id.letterOut);

            //if there is no error, displays the calculated grade
            if(!error){
                Calculator calc = new Calculator(assignment,mid,finals);
                gradeOut.setText(String.valueOf(calc.getScore()));
                letterOut.setText(calc.getGrade());
            }else{
                gradeOut.setText("0");
                letterOut.setText("N/A");
            }

        }
    }

    //function to display toast error
    private void displayError(String s)
    {
        int duration = Toast.LENGTH_LONG*2;

        //create a toast
        Toast toast = Toast.makeText(this, s, duration);

        //display toast
        toast.show();
    }
}