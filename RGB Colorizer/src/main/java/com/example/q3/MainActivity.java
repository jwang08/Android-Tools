package com.example.q3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //applies seekbar listener for each color input
        SeekBar slider1 = findViewById(R.id.redSeek);
        ChangeHandler temp1 = new ChangeHandler();
        slider1.setOnSeekBarChangeListener(temp1);

        SeekBar slider2 = findViewById(R.id.greenSeek);
        ChangeHandler temp2 = new ChangeHandler();
        slider2.setOnSeekBarChangeListener(temp2);

        SeekBar slider3 = findViewById(R.id.blueSeek);
        ChangeHandler temp3 = new ChangeHandler();
        slider3.setOnSeekBarChangeListener(temp3);
    }

    //actively reads the seekbar and updates the value text and color
    private class ChangeHandler implements SeekBar.OnSeekBarChangeListener
    {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            TextView redText = findViewById(R.id.redLabel);
            TextView greenText = findViewById(R.id.greenLabel);
            TextView blueText = findViewById(R.id.blueLabel);
            TextView output = findViewById(R.id.output);

            //Figures out which bar is the one that called the function
            if(seekBar.getId() == R.id.redSeek){
                redText.setText(String.valueOf(progress));
            }else if(seekBar.getId() == R.id.greenSeek){
                greenText.setText(String.valueOf(progress));
            }else if(seekBar.getId() == R.id.blueSeek){
                blueText.setText(String.valueOf(progress));
            }

            //uses the values of the value label to set the box color
            output.setBackgroundColor(Color.rgb(Integer.parseInt(redText.getText().toString())
                                                ,Integer.parseInt(greenText.getText().toString()),
                                                Integer.parseInt(blueText.getText().toString())));
        }

        public void onStartTrackingTouch(SeekBar seekBar)
        {
        }
        public void onStopTrackingTouch(SeekBar seekBar)
        {
        }
    }
}