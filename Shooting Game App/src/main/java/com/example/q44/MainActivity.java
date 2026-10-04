package com.example.q44;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Game game;
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creates the game and view
        game = new Game();
        gameView = new GameView(this, game);
        setContentView(gameView);

        //sets a timer to update the game each 20ms
        GameTimerTask task = new GameTimerTask(game, gameView);

        Timer timer = new Timer();

        timer.schedule(task, 0, 20);
    }
}