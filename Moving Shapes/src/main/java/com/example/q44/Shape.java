package com.example.q44;

import android.graphics.Color;

import java.util.Random;

public class Shape {
    public int type, centerX, centerY, size, speed, direction, color;

    //initializes the shapes values
    Shape(){
        Random r = new Random();
        type = r.nextInt(2)+1;
        centerX = r.nextInt(2401);
        centerY = r.nextInt(1081);
        size = r.nextInt(51)+50;
        speed = r.nextInt(11)+10;
        direction = r.nextInt(4)+1;
        color = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    //updates the shapes coords based on initial direction
    public void move(){
        if(direction == 1){
            centerX = (centerX + speed)%2400;
        } else if (direction == 2) {
            centerX = (centerX - speed + 2400)%2400;
        }else if (direction == 3) {
            centerY = (centerY + speed)%1080;
        }else if (direction == 4) {
            centerY = (centerY - speed + 1080)%1080;
        }
    }
}
