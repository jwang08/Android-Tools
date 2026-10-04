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

public class RemoveActivity extends AppCompatActivity {
    private final String FILE_NAME = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove);
    }

    public void submit(View view) {
        try {
            //open file for reading
            FileInputStream fin = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line, total = "";

            //grabs input
            EditText input = findViewById(R.id.input);
            int num = Integer.parseInt(input.getText().toString());

            int index = 1;

            //copies the text in file but the one to remove
            while ((line = bufferedReader.readLine()) != null)
            {
                if (num != index) {
                    total = total + line + "\n";
                }
                index++;
            }

            //close file
            fin.close();

            //open file for writing
            FileOutputStream fout = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            //rewrites file with the input removed
            fout.write(total.getBytes());

            //close file
            fout.close();

            //close file
            fin.close();
        } catch (Exception e) {}

        finish();
    }
}
