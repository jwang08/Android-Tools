package com.example.q33;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        updateView();
    }

    private void updateView() {
        //grabs current key from preferences and displays it
        EditText inputText = findViewById(R.id.keyInput);
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        int key = pref.getInt("KEY", 0);

        inputText.setText(String.valueOf(key));
    }

    public void submit(View view) {
        //saves current key and returns to first screen
        EditText inputText = findViewById(R.id.keyInput);
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("KEY", Integer.parseInt(inputText.getText().toString()));
        editor.apply();

        finish();
    }
}