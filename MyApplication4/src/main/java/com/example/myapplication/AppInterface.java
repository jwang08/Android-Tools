package com.example.myapplication;

import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.content.Context;
import android.view.View;
import android.widget.GridLayout;

public class AppInterface extends RelativeLayout {
    private TextView[][] board;
    private GridLayout grid;

    public AppInterface(Context context, int width) {
        super(context);
        int size = 3;

        //creates a grid layout for puzzle board
        final int DP = (int)(getResources().getDisplayMetrics().density);
        grid = new GridLayout(context);
        grid.setRowCount(6);
        grid.setColumnCount(3);
        addView(grid);

        //creates textviews for each node in the board and adds it to the grid layout
        board = new TextView[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new TextView(context);
                board[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                board[i][j].setTextColor(Color.BLACK);
                board[i][j].setTextSize((int) (width * 0.2));
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = width;
                params.height = width;
                params.rowSpec = GridLayout.spec(i, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 2;
                params.leftMargin = params.rightMargin = 2;
                board[i][j].setLayoutParams(params);
                grid.addView(board[i][j]);
            }
        }

        setBackgroundColor(Color.parseColor("#DDDDDD"));
    }

    //displays the board
    public void setBoard(char[][] info) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setText(String.valueOf(info[i][j]));
            }
        }
    }

    //Changes the background to red when the game is over
    public void changeBackground(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j].setBackgroundColor(Color.parseColor("#d43535"));
            }
        }
    }

}