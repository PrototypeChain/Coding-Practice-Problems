package com.practice.standard;

/*
* Given a maze, NxN matrix. A rat has to find a path from source to destination. maze[0][0]
* (left top corner)is the source and maze[N-1][N-1](right bottom corner) is destination. T
* here are few cells which are blocked, means rat cannot enter into those cells.
* Rat can move in any direction ( left, right, up and down).
*
*
* Input: A 2D-matrix with 0’s and 1’s fill in it. 0 means that cell is blocked and 1 means rat can move to that cell.
*
*
* Approach:

Create a solution matrix of the same structure as maze.
Whenever rat moves to cell in a maze, mark that particular cell in solution matrix.
At the end print the solution matrix, follow that 1’s from the top left corner, it will be that path for the rat.
Algorithm:

If rat reaches the destination
print the solution matrix.
Else
Mark the current cell in solution matrix as 1
If previous step is not in vertical direction (upwards) then move forward in the vertical direction(downwards) and recursively check if this movement leads to solution.
If movement in above step doesn’t lead to the solution and If previous step is not in horizontal direction (towards left) then move forward in the horizontal direction(towards right) and recursively check if this movement leads to solution.
If movement in above step doesn’t lead to the solution and If previous step is not in vertical direction (downwards) then move forward in the horizontal direction(upwards) and recursively check if this movement leads to solution.
If movement in above step doesn’t lead to the solution and If previous step is not in horizontal direction (towards right) then move forward in the horizontal direction(towards left) and recursively check if this movement leads to solution.
If none of the above solution works then BACKTRACK and mark the current cell as 0.

* */
public class RatInMaze {
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static int[][] solution;


    public boolean solve(int[][] maze, int x, int y, int n, String direction) {

        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafeMove(maze, x, y, n)) {
            // move to maze[x][y]
            solution[x][y] = 1;

            if (direction != UP && solve(maze, x + 1, y, n, DOWN)) {
                return true;
            }
            if (direction != DOWN && solve(maze, x - 1, y, n, UP)) {
                return true;
            }
            if (direction != LEFT && solve(maze, x, y + 1, n, RIGHT)) {
                return true;
            }
            if (direction != RIGHT && solve(maze, x, y - 1, n, LEFT)) {
                return true;
            }
            //if none of the options work out BACKTRACK undo the move
            solution[x][y] = 0;
        }
        return false;
    }

    public static boolean isSafeMove(int[][] maze, int x, int y, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] != 0) ? true : false;
    }

    public static void printSolution() {
        for (int i = 0; i < solution[0].length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RatInMaze ratInMaze = new RatInMaze();
        int[][] maze = {{1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1}
        };
        int startX = 0;
        int startY = 0;

        solution = new int[maze.length][maze.length];

        for (int i = 0; i < maze[0].length; i++) {
            for (int j = 0; j < maze.length; j++) {
                solution[i][j] = 0;
            }
        }

        if (ratInMaze.solve(maze, startX, startY, maze.length, ratInMaze.DOWN)) {
            printSolution();
        } else {
            System.out.println("No Path Found");
        }

    }
}
