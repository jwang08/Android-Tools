package com.example.q5;

public class Game {
    private int number;
    private int chances;

    public Game() {
        number = (int) (Math.random()*100)+1;
        chances = 8;
    }

    public int getNumber() {
        return number;
    }

    public int getChances() {
        return chances;
    }

    public void decrementChances(){
        chances--;
    }
}
