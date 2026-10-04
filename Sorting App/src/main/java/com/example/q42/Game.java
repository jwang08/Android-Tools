package com.example.q42;

import java.util.Random;

//Game model class
public class Game
{
    private int[] array;
    private int windowPosition;
    private int swaps;

    //Constructor of game
    public Game()
    {
        array = new int[10];
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            array[i] = rand.nextInt(100)+1;
        }
        windowPosition = rand.nextInt(9);
        swaps = 0;
    }
    public void move(){
        windowPosition = (windowPosition+1)%9;
    }

    public void swap(){
        int temp = array[windowPosition];
        array[windowPosition] = array[windowPosition+1];
        array[windowPosition+1] = temp;
        swaps++;
    }

    public int[] getArray() {
        return array;
    }

    public int getWindowPosition() {
        return windowPosition;
    }

    public boolean sorted(){
        for(int i = 0; i < 9; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public boolean gameOver(){
        return swaps>=45;
    }

    public String getMessage(){
        if(sorted()){
            return "You Win!";
        }else if (gameOver()){
            return  "You Lose.";
        }else{
            return String.valueOf(swaps);
        }
    }
}

