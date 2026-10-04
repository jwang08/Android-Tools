package com.example.q42;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

//Main program
public class MainActivity extends AppCompatActivity
{
    private final int SIZE = 10;    //each sentence has 10 words

    private Game game;                        //game model
    private AppInterface appInterface;        //app interface
    private GestureDetector gestureDetector;  //gesture detector
    private boolean gameOver;                 //flag for game over

    //Main screen
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //create game model
        game = new Game();

        //create app interface
        appInterface = new AppInterface(this, screenHeight());

        //display scrambled numbers
        appInterface.showCurrent(game.getArray(), game.getWindowPosition(), game.getMessage());
        //display initial scene
        setContentView(appInterface);

        //create gesture detector and attach event handler to it
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);

        //game is not over yet
        gameOver = false;
    }

    //Event handler of touch event
    public boolean onTouchEvent(MotionEvent event)
    {
        //pass touch event to gesture detector, if game is not over
        if (!gameOver) gestureDetector.onTouchEvent(event);

        return true;
    }

    //Method returns screen height of device
    private int screenHeight()
    {
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();

        return screenHeight;
    }

    //Event handler class of gesture detector
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        //Moves the window down
        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            if(!gameOver) {
                game.move();
                appInterface.showCurrent(game.getArray(), game.getWindowPosition(), game.getMessage());
                setContentView(appInterface);
            }

            return super.onSingleTapConfirmed(e);
        }

        //swaps the numbers in the window
        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            if(!gameOver){
                game.swap();
                appInterface.showCurrent(game.getArray(), game.getWindowPosition(), game.getMessage());
                setContentView(appInterface);
            }

            if(game.gameOver() || game.sorted()){
                gameOver = true;
            }

            return super.onDoubleTap(e);
        }
    }
}


