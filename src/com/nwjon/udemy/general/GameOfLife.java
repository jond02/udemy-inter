package com.nwjon.udemy.general;

public class GameOfLife {

    public static void main(String[] args) {

        int[][] m = {
                {1,0,1,1},
                {0,1,0,1},
                {1,0,0,0},
                {0,1,1,0}
        };

        print2DArray(m);

        int[][] next = getNextGeneration(m);

        print2DArray(next);

        next = getNextGeneration(next);

        print2DArray(next);


    }

    private static int[][] getNextGeneration(int[][] current) {

        //assuming N x N matrix
        int n = current.length;

        int[][] next = new int[n][n];

        //evaluate each cell to get it's state and save in next
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = getCellState(i, j, current);
            }
        }
        return next;
    }

    private static int getCellState(int row, int col, int[][] current) {

        //assuming N x N matrix

        int liveCount = 0;
        int lastCellIndex = current.length - 1;

        //if not the top left corner, check to the upper left
        if (row > 0 && col > 0) {
            liveCount += current[row - 1][col - 1];
        }

        //if not the top row, check top cells
        if (row > 0) {

            liveCount += current[row - 1][col];

            //if not in last col check top right
            if (col < lastCellIndex) {
                liveCount += current[row - 1][col + 1];
            }
        }

        //if not in rightmost col check to the right
        if (col < lastCellIndex) {
            liveCount += current[row][col + 1];
        }

        //if not in the leftmost col check to the left
        if (col > 0) {
            liveCount += current[row][col - 1];

            //if not in last row check bottom left
            if (row < lastCellIndex) {
                liveCount += current[row + 1][col - 1];
            }
        }

        //if not in last row check bottom
        if (row < lastCellIndex) {
            liveCount += current[row + 1][col];
        }

        //if not in the upper right check upper right
        if (row < lastCellIndex && col < lastCellIndex) {
            liveCount += current[row + 1][col + 1];
        }

        //if more than two neighbors than overcrowded
        //if less than two neighbors than lonely
        //if two neighbors than healthy
        return liveCount == 2 ? 1 : 0;
    }

    private static void print2DArray(int[][] data) {

        int n = data.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(data[i][j]);

                if (j == n - 1) {
                    System.out.println("\n");
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("next");
    }

}
