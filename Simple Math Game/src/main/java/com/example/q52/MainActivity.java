package com.example.q52;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.graphics.Color;

//Main program
public class MainActivity extends AppCompatActivity
{
    private final int ACTIVITY_TALK = 1;    //code used for speech recognition activity

    private float number1;           //number one in the question
    private float number2;           //number two in the question
    private float answer;            //correct answer to the question
    private String symbol;

    //Main screen
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check speech recognition is available
        if (!checkSpeechRecognition())
            Toast.makeText(this, "No speech recognition", Toast.LENGTH_LONG).show();
        else
        {
            //create a question
            createQuestion();
            //display the question
            displayQuestion();
        }
    }

    //Method checks whether speech recognition is available
    private boolean checkSpeechRecognition()
    {
        //create package manager
        PackageManager manager = getPackageManager();

        //find available speech recognition activities
        List<ResolveInfo> list = manager.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);

        //check there is at least one activity
        return list.size() > 0;
    }

    //Event handler of click button
    public void click(View view)
    {
        //listen to user
        listen();
    }

    //Method prompts the user to speak and recognizes user's speech
    private void listen()
    {
        //create speech recognition activity
        Intent listenIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        //set speech recognition model
        listenIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        //set a prompt
        listenIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say your answer");

        //set maximum number of results
        listenIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 10);

        //start speech recognition
        startActivityForResult(listenIntent, ACTIVITY_TALK);
    }

    //Method displays the results of user's speech
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //if the results are from speech recognition request
        if (requestCode == ACTIVITY_TALK)
        {
            //find the list of words that were recognized
            ArrayList<String> words = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            //display whether user answered correctly or not
            displayResult(words);
        }
    }

    //Method creates a question
    private void createQuestion()
    {
        Random random = new Random();

        //create two random integers between 1 and 100
        number1 = random.nextInt(100) + 1;
        number2 = random.nextInt(100) + 1;

        //Chooses operator at random
        int index = random.nextInt(4);
        switch(index){
            case 0:
                symbol = " + ";
                answer = number1 + number2;
                break;
            case 1:
                symbol = " - ";
                answer = number1 - number2;
                break;
            case 2:
                symbol = " * ";
                answer = number1 * number2;
                break;
            case 3:
                answer = (float) Math.round((number1 / number2) * 10) / 10;
                symbol = " / ";
                break;
            default:
                break;

        }
    }

    //Method displays a question
    private void displayQuestion()
    {
        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText("" + (int)number1 + symbol + (int)number2 + " = ?");
    }

    //Method displays whether the user answered question correctly
    private void displayResult(ArrayList<String> words)
    {
        //text view for output
        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setBackgroundColor(Color.parseColor("#009900"));

        //if list of recognized words contains correct the answer, say correct
        if (words.contains(answer+"")||words.contains((int)answer+""))
            resultTextView.setText("Correct");
            //otherwise say incorrect
        else
            resultTextView.setText("Incorrect");
    }
}
