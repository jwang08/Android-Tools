package com.example.q7;

import android.widget.GridLayout;

public class Game {
    private char[][] current;
    private char[][] goal;
    private int x;
    private int y;
    private final char BLANK = ' ';

    //generates new board and goal on creation
    public Game() {
        Generator gen = new Generator();
        current = gen.generateInitialBoard();
        goal = gen.generateGoalBoard();
        for(int i = 0; i < current.length; i++){
            for (int j= 0; j < current[i].length; j++){
                if(current[i][j] == ' '){
                    x = j;
                    y = i;
                }
            }
        }
    }

    //functions to move the blank space and update the coords
    public void up(){
        try{
            current[y][x] = current[y-1][x];
            current[y-1][x] = BLANK;
            y = y-1;
        }catch (Exception e){

        }
    }
    public void down(){
        try{
            current[y][x] = current[y+1][x];
            current[y+1][x] = BLANK;
            y = y+1;
        }catch (Exception e){

        }
    }
    public void left(){
        try{
            current[y][x] = current[y][x-1];
            current[y][x-1] = BLANK;
            x = x-1;
        }catch (Exception e){

        }
    }
    public void right(){
        try{
            current[y][x] = current[y][x+1];
            current[y][x+1] = BLANK;
            x = x+1;
        }catch (Exception e){

        }
    }

    public char[][] getCurrent() {
        return current;
    }

    public char[][] getGoal() {
        return goal;
    }
}
