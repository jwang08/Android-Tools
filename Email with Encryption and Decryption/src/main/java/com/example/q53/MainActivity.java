package com.example.q53;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Main activity
public class MainActivity extends AppCompatActivity
{
    //Main screen
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Event handler method of send button
    public void send(View v)
    {
        //read email address
        EditText addressEditText = findViewById(R.id.address);
        String address = addressEditText.getText().toString();

        //read subject of email
        EditText subjectEditText = findViewById(R.id.subject);
        String subject = subjectEditText.getText().toString();

        //read text of email
        EditText messageEditText = findViewById(R.id.message);
        String message = messageEditText.getText().toString();

        //create email activity
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");

        //set recipients of email
        String[] recipient = new String[]{address};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);

        //set subject of email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

        //set text of email
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        //start email activity
        startActivity(emailIntent);
    }

    public void encrypt(View view) {
        //Grabs the input
        EditText inputText = findViewById(R.id.message);
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
        EditText inputText = findViewById(R.id.message);
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
        EditText inputText = findViewById(R.id.message);
        SharedPreferences pref = getSharedPreferences("Key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("TEXT", inputText.getText().toString());
        editor.apply();

        //goes to second activity
        Intent secondActivity = new Intent(this, Second.class);
        startActivity(secondActivity);
    }
}
/*
On first run, connect the app to an email account
*/
