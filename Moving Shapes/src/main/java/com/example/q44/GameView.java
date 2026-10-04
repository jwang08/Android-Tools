package com.example.q44;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    Game game;
    Paint p;

    public GameView(Context context, Game g) {
        super(context);
        game = g;
        p = new Paint();
        p.setStyle(Paint.Style.FILL);
    }

    //displays the shapes based on their given coords
    public void onDraw(Canvas canvas){
        Shape[] array = game.get();
        //sorts from circle or square
        for (int i = 0; i < array.length; i++){
            p.setColor(array[i].color);
            if(array[i].type == 1){
                canvas.drawCircle(array[i].centerX, array[i].centerY, array[i].size, p);
            } else if (array[i].type == 2) {
                canvas.drawRect(array[i].centerX-array[i].size, array[i].centerY-array[i].size, array[i].centerX+array[i].size, array[i].centerY+array[i].size, p);
            }
        }
    }
}
