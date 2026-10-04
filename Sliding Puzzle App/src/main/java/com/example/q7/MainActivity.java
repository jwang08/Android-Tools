package com.example.q7;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final int SIZE = 3;
    private Game gameBoard;
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenSize = getWindowManager().getCurrentWindowMetrics().getBounds().width();
        int width = screenSize/SIZE;

        gameBoard = new Game();
        ButtonHandler buttonHandler = new ButtonHandler();
        appInterface = new AppInterface(this, SIZE, width, buttonHandler);
        appInterface.setBoard(gameBoard.getCurrent());
        appInterface.setGoal(gameBoard.getGoal());
        setContentView(appInterface);
    }

    //Moves blank space based on button pressed
    private class ButtonHandler implements View.OnClickListener
    {
        public void onClick(View v){
            //Finds which button was pressed and uses relevant function to move the blank
            switch (appInterface.findButton(v.getId())){
                case 1:
                    gameBoard.up();
                    break;
                case 2:
                    gameBoard.down();
                    break;
                case 3:
                    gameBoard.left();
                    break;
                case 4:
                    gameBoard.right();
                    break;
            }
            //updates the board
            appInterface.setBoard(gameBoard.getCurrent());
            setContentView(appInterface);

            //checks if the board is the goal
            if(Arrays.deepEquals(gameBoard.getCurrent(), gameBoard.getGoal())){
                appInterface.end();
                toast("You Win!");
            }
        }
    }

    private void toast(String s)
    {
        int duration = Toast.LENGTH_LONG*2;

        //create a toast
        Toast toast = Toast.makeText(this, s, duration);

        //display toast
        toast.show();
    }
}