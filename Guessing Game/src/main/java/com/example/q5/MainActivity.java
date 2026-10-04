package com.example.q5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates a new game to run
        game = new Game();
    }

    //When the submit button is clicked, it checks if the input is correct and other calculations
    public void submit(View view) {
        EditText intputText = findViewById(R.id.input);
        TextView chancesText = findViewById(R.id.guesses);
        TextView infoText = findViewById(R.id.info);
        Button submitButton = findViewById(R.id.submit);

        //input conversion
        String s = intputText.getText().toString();
        if(s.equals("")){
            s = "0";
        }
        int input = Integer.parseInt(s);

        //Game update
        int number = game.getNumber();
        game.decrementChances();
        int chances = game.getChances();

        //Input calculator
        //if correct, end game and disable inputs
        if(input == number){
            chancesText.setText("Chances: " + chances);
            infoText.setText("Correct Guess!");
            intputText.setEnabled(false);
            submitButton.setEnabled(false);
            showDialogBox();

        //if no more chances, end game and disable inputs
        }else if (chances == 0){
            chancesText.setText("Chances: " + chances);
            infoText.setText("Chances Exceeded");
            intputText.setEnabled(false);
            submitButton.setEnabled(false);
            showDialogBox();
        //if the game is still going, tell the user if the number is higher or lower than input
        } else if (number > input) {
            chancesText.setText("Chances: " + chances);
            infoText.setText("Greater");
        }else {
            chancesText.setText("Chances: " + chances);
            infoText.setText("Less");
        }
    }

    //displays dialog box when game ends
    private void showDialogBox()
    {
        //create dialog box
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);

        //set message on dialog box
        dialogBox.setMessage("Want to play again?");

        //create an event handler for dialog box
        DialogBoxListener temp = new DialogBoxListener();

        //add event handler to dialog box buttons
        dialogBox.setPositiveButton("Yes", temp);
        dialogBox.setNegativeButton("No", temp);
        dialogBox.setNeutralButton("Cancel", temp);

        //show dialog box
        dialogBox.show();
    }


    //based on dialog box input, end activity or resets game again
    private class DialogBoxListener implements DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int id)
        {
            if (id == -1){
                setContentView(R.layout.activity_main);
                game = new Game();
            }else if (id == -2) {
                MainActivity.this.finish();
            }else{

            }
        }
    }


}