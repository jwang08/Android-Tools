package com.example.q35;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyActivity extends AppCompatActivity {

    private DatabaseManager manager = MainActivity.manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify);
    }

    public void submit(View view) {
        //grabs input
        EditText placeText = findViewById(R.id.placeText);
        EditText passText = findViewById(R.id.passText);
        String place = placeText.getText().toString();
        String pass = passText.getText().toString();

        //modifies password pair in database
        Password password = new Password(place, pass);

        manager.update(password);

        finish();
    }
}
