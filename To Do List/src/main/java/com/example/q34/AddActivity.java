package com.example.q34;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class AddActivity extends AppCompatActivity {
    private final String FILE_NAME = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
    }

    public void submit(View view) {
        try {
            //open file for writing as append
            FileOutputStream fout = openFileOutput(FILE_NAME, Context.MODE_PRIVATE | Context.MODE_APPEND);

            //reads input
            EditText nameEditText = findViewById(R.id.input);
            String task = nameEditText.getText().toString();

            String line = task + "\n";

            //writes input to end of file
            fout.write(line.getBytes());

            //close file
            fout.close();
        }catch (Exception e){}

        finish();
    }
}
