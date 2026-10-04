package com.example.myapplication;

import android.util.Log;

public class Game {
    private char[][] current;
    private char[][] goal;
    private int x;
    private int y;
    private final char BLANK = ' ';

    //generates new board and goal on creation
    public Game() {
        Generator gen = new Generator();
        current = gen.generateBoard();
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

    //logic for swaping the tiles around
    public void swap(int u, int v, int x, int y){
        if(check(u, v, x, y)){
            char temp = current[y][x];
            current[y][x] = current[v][u];
            current[v][u] = temp;
        }
    }

    //checks if the move is valid
    public boolean check(int u, int v, int x, int y){
        if(current[v][u] != BLANK && current[y][x] != BLANK){
            return false;
        }
        boolean vertical = false;
        boolean horizontal = false;
        if(Math.abs(u-x) == 1){
            vertical = true;
        }
        if(Math.abs(v-y) == 1){
            horizontal = true;
        }
        return horizontal ^ vertical;
    }

    public char[][] getCurrent() {
        return current;
    }

    public char[][] getGoal() {
        return goal;
    }
}
