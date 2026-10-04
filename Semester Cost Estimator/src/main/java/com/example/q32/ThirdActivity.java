package com.example.q32;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private University uni = MainActivity.uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        updateView();
    }

    private void updateView() {
        //Updates the radio group if there was an input previously
        String status = uni.getStatus();
        RadioButton un = findViewById(R.id.under);
        RadioButton gra = findViewById(R.id.gradu);
        if(status.equals("undergraduate")){
            un.setChecked(true);
        }else if (status.equals("graduate")){
            gra.setChecked(true);
        }
    }

    public void next(View view) {
        //Saves inputs and goes to fourth screen
        RadioGroup input = findViewById(R.id.radio);
        int id = input.getCheckedRadioButtonId();
        if(id == R.id.under){
            uni.setStatus("undergraduate");
        }else if (id == R.id.gradu){
            uni.setStatus("graduate");
        }

        Intent fourthAct = new Intent(this, FourthActivity.class);
        startActivity(fourthAct);
    }
    public void back(View view) {
        //Saves inputs and goes back to second screen
        RadioGroup input = findViewById(R.id.radio);
        int id = input.getCheckedRadioButtonId();
        if(id == R.id.under){
            uni.setStatus("undergraduate");
        }else if (id == R.id.gradu){
            uni.setStatus("graduate");
        }

        finish();
    }
}