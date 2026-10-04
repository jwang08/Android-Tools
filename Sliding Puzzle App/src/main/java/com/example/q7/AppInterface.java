package com.example.q7;

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
    private TextView[][] goal;
    private Button up, down, left, right;

    public AppInterface(Context context, int size, int width, View.OnClickListener buttonHandler) {
        super(context);

        //creates a grid layout for puzzle board
        final int DP = (int)(getResources().getDisplayMetrics().density);
        GridLayout grid = new GridLayout(context);
        grid.setId(GridLayout.generateViewId());
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
                params.height = width*3/4;
                params.rowSpec = GridLayout.spec(i, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 2;
                params.leftMargin = params.rightMargin = 2;
                board[i][j].setLayoutParams(params);
                grid.addView(board[i][j]);
            }
        }

        //creates textviews for each node in the goal board and adds it to the grid layout
        goal = new TextView[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                goal[i][j] = new TextView(context);
                goal[i][j].setBackgroundColor(Color.parseColor("#AFD3A5"));
                goal[i][j].setTextColor(Color.BLACK);
                goal[i][j].setTextSize((int) (width * 0.2));
                goal[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = width;
                params.height = width*3/4;
                params.rowSpec = GridLayout.spec(i+3, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 2;
                params.leftMargin = params.rightMargin = 2;
                goal[i][j].setLayoutParams(params);
                grid.addView(goal[i][j]);
            }
        }


        //Four button creations for up,down,left,right
        up = new Button(context);
        up.setId(Button.generateViewId());
        up.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        up.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        up.setText("up");
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(0, 0);
        params2.width = width*3/4;
        params2.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params2.topMargin = 40*DP;
        params2.addRule(RelativeLayout.BELOW, grid.getId());
        up.setLayoutParams(params2);
        up.setOnClickListener(buttonHandler);
        addView(up);

        down = new Button(context);
        down.setId(Button.generateViewId());
        down.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        down.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        down.setText("down");
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(0, 0);
        params3.width = width*3/4;
        params3.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params3.topMargin = 40*DP;
        params3.addRule(RelativeLayout.BELOW, grid.getId());
        params3.addRule(RelativeLayout.END_OF, up.getId());
        down.setLayoutParams(params3);
        down.setOnClickListener(buttonHandler);
        addView(down);

        left = new Button(context);
        left.setId(Button.generateViewId());
        left.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        left.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        left.setText("left");
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(0, 0);
        params5.width = width*3/4;
        params5.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params5.topMargin = 40*DP;
        params5.addRule(RelativeLayout.BELOW, grid.getId());
        params5.addRule(RelativeLayout.END_OF, down.getId());
        left.setLayoutParams(params5);
        left.setOnClickListener(buttonHandler);
        addView(left);

        right = new Button(context);
        right.setId(Button.generateViewId());
        right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        right.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        right.setText("right");
        RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(0, 0);
        params6.width = width*3/4;
        params6.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params6.topMargin = 40*DP;
        params6.addRule(RelativeLayout.BELOW, grid.getId());
        params6.addRule(RelativeLayout.END_OF, left.getId());
        right.setLayoutParams(params6);
        right.setOnClickListener(buttonHandler);
        addView(right);

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
    //displays the goal board
    public void setGoal(char[][] info) {
        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal[i].length; j++) {
                goal[i][j].setText(String.valueOf(info[i][j]));
            }
        }
    }

    //helps find what button was pressed for MainActivity
    public int findButton(int id){
        if(id == up.getId()){
            return 1;
        }else if(id == down.getId()){
            return 2;
        }else if(id == left.getId()){
            return 3;
        }else if(id == right.getId()){
            return 4;
        }
        return -1;
    }

    //ends the game
    public void end(){
        up.setEnabled(false);
        down.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
    }
}