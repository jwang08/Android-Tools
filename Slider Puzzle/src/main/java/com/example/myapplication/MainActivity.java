package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private AppInterface appInterface;
    private GestureDetector gestureDetector;

    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game();

        //displays the 3x3 board game
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();
        int width = screenWidth/3;
        int gameHeight = screenWidth;
        appInterface = new AppInterface(this, width);
        appInterface.setBoard(game.getCurrent());
        setContentView(appInterface);

        //creates a event handler for inputs
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    //checks if the game is done and stops input if so
    public boolean onTouchEvent(MotionEvent event)
    {
        //pass touch event to gesture detector, if game is not over
        if (!gameOver) gestureDetector.onTouchEvent(event);

        return true;
    }

    //finds location of the swipes and then moves the board accordingly
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener {
        //Event handler of swipes
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            //checks if the swipes are inside the board
            if(inside(event1) & inside(event2)){
                game.swap(getCol(event1), getRow(event1), getCol(event2), getRow(event2));
            }
            //updates the board
            appInterface.setBoard(game.getCurrent());
            setContentView(appInterface);

            //checks if the board is the goal
            if(Arrays.deepEquals(game.getCurrent(), game.getGoal())){
                end();
            }
            return true;
        }

        //helper function to check if the inputs are within the board
        public boolean inside(MotionEvent event){
            float gameHeight = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            return event.getY() < gameHeight;
        }

        //helper function to find the column of the tiles swiped
        private int getCol(MotionEvent event){
            float gameWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            if(event.getX() < gameWidth /3){
                return 0;
            } else if (event.getX() < gameWidth* 2/3) {
                return 1;
            }else{
                return 2;
            }
        }

        //helper function to find the row of the tiles swiped
        private int getRow(MotionEvent event){
            float gameHeight = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            if(event.getY() < gameHeight /3){
                return 0;
            } else if (event.getY() < gameHeight* 2/3) {
                return 1;
            }else{
                return 2;
            }
        }

        //prevents user input after the game is over
        public void end(){
            gameOver = true;
            appInterface.changeBackground();
            setContentView(appInterface);
        }
    }
}