package com.example.q6;

import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.TypedValue;
import android.graphics.Color;
import android.content.Context;
import android.view.View;

public class AppInterface extends RelativeLayout {
    private EditText input;
    private TextView output;

    public AppInterface(Context context, View.OnClickListener buttonHandler) {
        super(context);
        final int DP = (int)(getResources().getDisplayMetrics().density);

        //textview for input label
        TextView prompt = new TextView(context);
        prompt.setId(TextView.generateViewId());
        prompt.setTextColor(Color.parseColor("#000000"));
        prompt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        prompt.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        prompt.setText("Enter Number: ");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, 1);
        params.topMargin = 50*DP;
        prompt.setLayoutParams(params);
        addView(prompt);

        //input box
        input = new EditText(context);
        input.setId(EditText.generateViewId());
        input.setTextColor(Color.parseColor("#000000"));
        input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        input.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        input.setHint("0");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, prompt.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, 1);
        input.setLayoutParams(params);
        addView(input);

        //textview for prime information
        output = new TextView(context);
        output.setId(TextView.generateViewId());
        output.setTextColor(Color.parseColor("#000000"));
        output.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        output.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        output.setText("N/A");
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, input.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, 1);
        output.setLayoutParams(params);
        addView(output);

        //submit button
        Button button = new Button(context);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        button.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        button.setText("Submit");
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 40*DP;
        params.addRule(RelativeLayout.BELOW, output.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, 1);
        button.setLayoutParams(params);
        button.setOnClickListener(buttonHandler);
        addView(button);
    }

    //getter function for input calculations in MainActivity
    public int getInput(){
        String s = input.getText().toString();
        return Integer.parseInt(s);
    }

    //setter to update output display
    public void setOutput(String s){
        output.setText(s);
    }
}