package lrl6.timus;

import java.util.Scanner;

public class task1401 {
    private static int[][] board;
    private static int tileNumber = 1;
    private static int n;
    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        size = 1 << n; // 2^n
        board = new int[size + 1][size + 1];

        board[x][y] = 0;
        tile(1, 1, size, x, y);
        printBoard();
    }

    private static void tile(int row, int col, int size, int missingRow, int missingCol) {
        if (size == 1) return;

        int half = size / 2;
        int currentTile = tileNumber++;

        int missingQuadrant = getQuadrant(row, col, half, missingRow, missingCol);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int quad = i * 2 + j + 1;
                if (quad != missingQuadrant) {
                    int centerRow = row + i * half + half - 1;
                    int centerCol = col + j * half + half - 1;
                    board[centerRow][centerCol] = currentTile;
                }
            }
        }


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int quad = i * 2 + j + 1;
                int newRow = row + i * half;
                int newCol = col + j * half;
                int newMissingRow, newMissingCol;

                if (quad == missingQuadrant) {

                    newMissingRow = missingRow;
                    newMissingCol = missingCol;
                } else {

                    newMissingRow = row + i * half + half - 1;
                    newMissingCol = col + j * half + half - 1;
                }
                tile(newRow, newCol, half, newMissingRow, newMissingCol);
            }
        }
    }

    private static int getQuadrant(int row, int col, int half, int missingRow, int missingCol) {
        if (missingRow < row + half) {
            if (missingCol < col + half) return 1;
            else return 2;
        } else {
            if (missingCol < col + half) return 3;
            else return 4;
        }
    }

    private static void printBoard() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(board[i][j] + (j == size ? "" : " "));
            }
            System.out.println();
        }
    }
}