package com.example.q43;

import java.util.LinkedList;

public class DoodleModel {
    private int color;
    private LinkedList<Point> list;

    public DoodleModel() {
        this.color = 0;
        this.list = new LinkedList<>();
    }

    public void nextColor(){
        color = (color + 1)%8;
    }

    public void addPoint(float x, float y){
        Point p = new Point(x, y, color);
        list.add(p);
    }

    public int getColor() {
        return color;
    }

    public LinkedList<Point> getPoints() {
        return list;
    }
}
