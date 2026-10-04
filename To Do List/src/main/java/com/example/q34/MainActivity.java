package com.example.q34;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private final String FILE_NAME = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateView();
    }

    private void updateView() {
        try {
            //open file for reading
            FileInputStream fin = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line, out = "";

            int num = 1;

            //Displays all the tasks on file and numbers them
            while ((line = bufferedReader.readLine()) != null)
            {
                out = out + num + ": " + line + "\n";
                num++;
            }

            //display collection the of lines
            TextView output = findViewById(R.id.output);
            output.setText(out);

            //close file
            fin.close();
        } catch (Exception e) {}
    }

    public void add(View view) {
        //Goes to add screen
        Intent addAct = new Intent(this, AddActivity.class);
        startActivity(addAct);
    }

    public void remove(View view) {
        //goes to remove screen
        Intent removeAct = new Intent(this, RemoveActivity.class);
        startActivity(removeAct);
    }

    public void modify(View view) {
        //goes to modify screen
        Intent modifyAct = new Intent(this, ModifyActivity.class);
        startActivity(modifyAct);
    }
}