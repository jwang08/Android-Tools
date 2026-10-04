package com.example.q33;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        //Gets the preferences and displays the current text
        super.onStart();
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        EditText inputText = findViewById(R.id.input);
        String start = pref.getString("TEXT", "hi");

        inputText.setText(start);
    }

    public void encrypt(View view) {
        //Grabs the input
        EditText inputText = findViewById(R.id.input);
        String input = inputText.getText().toString();

        //access preferences and retrieve key
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        int key = pref.getInt("KEY", 0);

        //encrypts the text based on key from preference and displays it
        Model model = new Model();
        model.set(key);
        inputText.setText(model.encrypt(input));
    }

    public void decrypt(View view) {
        //grabs input
        EditText inputText = findViewById(R.id.input);
        String input = inputText.getText().toString();

        //access preferences and retrieve key
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        int key = pref.getInt("KEY", 0);

        //decrypts the text based on key from preference and displays it
        Model model = new Model();
        model.set(key);
        inputText.setText(model.decrypt(input));
    }

    public void key(View view) {
        //Saves input into preferences
        EditText inputText = findViewById(R.id.input);
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("TEXT", inputText.getText().toString());
        editor.apply();

        //goes to second activity
        Intent secondActivity = new Intent(this, SecondActivity.class);
        startActivity(secondActivity);
    }
}