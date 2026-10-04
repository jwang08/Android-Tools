package com.example.q34;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ModifyActivity extends AppCompatActivity {
    private final String FILE_NAME = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify);
    }

    public void submit(View view) {
        try {
            //open file for reading
            FileInputStream fin = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line, total = "";

            //grabs the input
            EditText numText = findViewById(R.id.taskNum);
            int num = Integer.parseInt(numText.getText().toString());

            EditText taskText = findViewById(R.id.taskText);
            String task = taskText.getText().toString();

            int index = 1;

            //copies the file but changes the line to modified version
            while ((line = bufferedReader.readLine()) != null)
            {
                if (num != index) {
                    total = total + line + "\n";
                }else{
                    total = total + task + "\n";
                }
                index++;
            }

            //close file
            fin.close();

            //open file for writing
            FileOutputStream fout = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            //writes new version with modified line
            fout.write(total.getBytes());

            //close file
            fout.close();

            //close file
            fin.close();
        } catch (Exception e) {}

        finish();
    }
}
