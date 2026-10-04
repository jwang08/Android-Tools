package com.example.q32;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {
    private University uni = MainActivity.uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);
        updateView();
    }

    private void updateView() {
        //Grabs all the values from uni and displays it
        TextView output = findViewById(R.id.output);
        String status = "";
        if(uni.getStatus().equals("undergraduate")){
            status = "Undergraduate";
        } else if (uni.getStatus().equals("graduate")) {
            status = "Graduate";
        }else{
            status = "N/A";
        }
        String s = "Credits: " + uni.getCredits() +
                "\nStatus: " + status +
                "\nDormitory: " + uni.getDorm() +
                "\nDining: " + uni.getDining() +
                "\nTotal: " + uni.getTotal();

        output.setText(s);
    }

    public void back(View view) {
        //Goes back to fourth screen
        finish();
    }
}