package com.example.q44;

public class Game {
    Shape[] array;
    int number;

    //creates game and adds the shapes
    public Game(){
        number = 20;
        array = new Shape[number];
        for (int i = 0; i < number; i++){
            array[i] = new Shape();
        }
    }

    //updates the coords of all the shapes
    public void move(){
        for (int i = 0; i < number; i++){
            array[i].move();
        }
    }

    public Shape[] get(){
        return  array;
    }
}
