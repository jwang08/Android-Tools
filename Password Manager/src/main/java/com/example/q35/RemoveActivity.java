package com.example.q35;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {

    private DatabaseManager manager = MainActivity.manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove);
    }

    public void submit(View view) {
        //grabs input
        EditText placeText = findViewById(R.id.input);
        String place = placeText.getText().toString();

        //deletes password pair from database
        manager.delete(place);

        finish();
    }
}
