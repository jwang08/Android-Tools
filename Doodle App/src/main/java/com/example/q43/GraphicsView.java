package com.example.q43;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.LinkedList;

public class GraphicsView extends View
{
    private DoodleModel doodleModel;
    private Paint paint;
    //Constructor of graphics view
    public GraphicsView(Context context, DoodleModel doodle)
    {
        super(context);
        doodleModel = doodle;
        paint = new Paint();
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.FILL);
    }

    //Method draws graphics view
    public void onDraw(Canvas canvas)
    {
        LinkedList<Point> list = doodleModel.getPoints();
        for(int i = 0; i < list.size(); i++){
            paint.setColor(convert(list.get(i).color));
            canvas.drawPoint(list.get(i).x,list.get(i).y,paint);
        }
        paint.setColor(convert(doodleModel.getColor()));
        canvas.drawRect(getWidth()-250, getHeight()-250, getWidth(), getHeight(), paint);
    }

    //coverts the code to the color value for each respective code
    private int convert(int code){
        switch(code) {
            case 0:
                return Color.parseColor("#000000");
            case 1:
                return Color.parseColor("#FF0000");
            case 2:
                return Color.parseColor("#008000");
            case 3:
                return Color.parseColor("#0000FF");
            case 4:
                return Color.parseColor("#FFFF00");
            case 5:
                return Color.parseColor("#964B00");
            case 6:
                return Color.parseColor("#808080");
            case 7:
                return Color.parseColor("#FFFFFF");
            default:
                return -1;
        }
    }
}
