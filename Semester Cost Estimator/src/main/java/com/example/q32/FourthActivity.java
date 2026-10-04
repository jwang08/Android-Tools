package com.example.q32;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    private University uni = MainActivity.uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        updateView();
    }

    private void updateView() {
        //Updates the checkboxes if there was an input previously
        CheckBox dorm = findViewById(R.id.dormitory);
        CheckBox dine = findViewById(R.id.dining);

        if(uni.getDorm()){
            dorm.setChecked(true);
        }
        if(uni.getDining()){
            dine.setChecked(true);
        }
    }

    public void next(View view) {
        //Saves inputs and goes to fifth screen
        CheckBox dorm = findViewById(R.id.dormitory);
        CheckBox dine = findViewById(R.id.dining);

        uni.setDorm(dorm.isChecked());
        uni.setDining(dine.isChecked());

        Intent fifthAct = new Intent(this, FifthActivity.class);
        startActivity(fifthAct);
    }
    public void back(View view) {
        //Saves inputs and goes back to third screen
        CheckBox dorm = findViewById(R.id.dormitory);
        CheckBox dine = findViewById(R.id.dining);

        uni.setDorm(dorm.isChecked());
        uni.setDining(dine.isChecked());

        finish();
    }
}