package com.example.q35;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates date base to save data across screens
        manager = new DatabaseManager(this);
        updateView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateView();
    }

    private void updateView() {
        LinearLayout scene = findViewById(R.id.layout);

        //clears textviews to prevent repeating
        scene.removeAllViews();

        //grabs all passwords
        LinkedList<Password> list = manager.all();

        //displays them all as textviews
        for (int i = 0; i < list.size(); i++)
        {
            TextView label = new TextView(this);
            label.setId(TextView.generateViewId());
            label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            label.setText(list.get(i).getPlace() + " | " + list.get(i).getPwd());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, 0);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            label.setLayoutParams(params);
            scene.addView(label);
        }
    }


    public void add(View view) {
        //goes to add screen
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