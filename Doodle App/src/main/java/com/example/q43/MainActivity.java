package com.example.q43;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DoodleModel doodle;
    private GraphicsView graphics;
    private GestureDetector gestureDetector;


    //sets up the dynamic view and touch event handler
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doodle = new DoodleModel();
        graphics = new GraphicsView(this, doodle);
        setContentView(graphics);
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        //checks if it is within the square and updates the color if it is
        if(check(event.getX(), event.getY())){
            gestureDetector.onTouchEvent(event);
        }else{
            //adds points when the user moves their input
            if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
                doodle.addPoint(event.getX(), event.getY());
                graphics.postInvalidate();
            }
        }


        return true;
    }

    //helper function to check if the input is on the square
    private boolean check(float x, float y){
        return x > graphics.getWidth() - 250 && y > graphics.getHeight() - 250;
    }

    //changes the square color
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            doodle.nextColor();
            graphics.postInvalidate();
            return super.onSingleTapConfirmed(e);
        }
    }
}