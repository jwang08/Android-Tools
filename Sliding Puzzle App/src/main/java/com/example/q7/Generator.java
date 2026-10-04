package com.example.q7;

import java.util.Random;

public class Generator
{
    private final char BLANK = ' ';
    private Random random;

    public Generator()
    {
        random = new Random();
    }

    public char[][] generateInitialBoard()
    {
        char[][] board = new char[3][3];

        int[] list = createList();

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                if (list[k] == 0)
                    board[i][j] = BLANK;
                else
                    board[i][j] = (char)('0' + list[k]);

                k++;
            }

        return board;
    }

    public char[][] generateGoalBoard()
    {
        char[][] board = new char[3][3];

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = (char)('0' + k + 1);
                k++;
            }

        board[2][2] = BLANK;

        return board;
    }

    private int[] createList()
    {
        int[] list = new int[9];

        for (int i = 0; i < 9; i++)
            list[i] = i;

        int k = 8;
        for (int i = 0; i < 9; i++)
        {
            int j = random.nextInt(k+1);

            int temp = list[j];
            list[j] = list[k];
            list[k] = temp;

            k = k - 1;
        }

        return list;
    }
}
