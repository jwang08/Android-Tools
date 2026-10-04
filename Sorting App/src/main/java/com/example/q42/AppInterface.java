package com.example.q42;


import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.content.Context;
import android.util.TypedValue;

//Game interface class
public class AppInterface extends RelativeLayout
{
    private final int SIZE = 10;   //sentence has 10 words
    private TextView[] array;     //array of text views to display words
    TextView text;

    //Constructor of game interface
    public AppInterface(Context context, int screenHeight)
    {
        super(context);

        //create array of 10 text views
        array = new TextView[SIZE];

        //go thru each text view
        for (int i = 0; i < SIZE; i++)
        {
            //create text view
            array[i] = new TextView(context);

            //set id of text view
            array[i].setId(TextView.generateViewId());

            //set color, background, font, gravity of text view
            array[i].setBackgroundColor(Color.parseColor("#32a852"));
            array[i].setTextColor(Color.BLACK);
            array[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            array[i].setGravity(Gravity.CENTER);

            //create layout parameter for text view
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);

            //place each text view below the previous text view
            if (i > 0) params.addRule(RelativeLayout.BELOW, array[i-1].getId());

            //set width and height of text view
            params.width = 400;
            params.height = screenHeight*3/(SIZE*4);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);

            //set top margin of text view
            params.topMargin = 2;

            //set layout parameter of text view
            array[i].setLayoutParams(params);

            //add text view to relative layout
            addView(array[i]);
        }

        text = new TextView(context);
        text.setId(TextView.generateViewId());
        text.setText("N/A");
        text.setTextSize(30);
        text.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
        params.addRule(RelativeLayout.BELOW, array[9].getId());
        params.width = 1000;
        params.height = 600;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(Gravity.CENTER);
        text.setLayoutParams(params);
        addView(text);
    }

    //Method displays current order of words
    public void showCurrent(int[] a, int windowPosition, String message) {
        for (int i = 0; i < SIZE; i++) {
            array[i].setText(String.valueOf(a[i]));
        }

        for (int i = 0; i < SIZE; i++) {
            array[i].setBackgroundColor(Color.parseColor("#32a852"));
        }

        array[windowPosition].setBackgroundColor(Color.parseColor("#2e9688"));
        array[windowPosition+1].setBackgroundColor(Color.parseColor("#2e9688"));
        text.setText(message);
    }

    //Method changes background color of all numbers to red
    public void stop()
    {
        //change background of each text view to red
        for (int i = 0; i < SIZE; i++)
            array[i].setBackgroundColor(Color.parseColor("#990000"));
    }
}
