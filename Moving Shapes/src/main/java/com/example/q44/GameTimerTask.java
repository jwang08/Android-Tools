package com.example.q44;

import java.util.TimerTask;

public class GameTimerTask  extends TimerTask {
    Game game;
    GameView gView;

    public GameTimerTask(Game game, GameView gView) {
        this.game = game;
        this.gView = gView;
    }

    public void run(){
        game.move();
        gView.postInvalidate();
    }
}
