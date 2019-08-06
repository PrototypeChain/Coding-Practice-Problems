package com.practice.matrix;

public class CountIsland {

    static final int ROW = 5, COL = 5;

    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
        CountIsland I = new CountIsland();
        System.out.println("Number of islands is: " + I.countIsland(M));
    }

    int countIsland(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    count++;
                    floodFill(M, i, j, visited);

                }

        return count;
    }

    public static void floodFill(int[][] sea, int row, int col, boolean[][] checked) {
        if (sea[row][col] == 0 || checked[row][col]) return;

        checked[row][col] = true;

        if (col < sea.length - 1) floodFill(sea, row, col+1, checked);
        if (row < sea.length - 1) floodFill(sea, row+1, col, checked);
        if (col > 0) floodFill(sea, row, col-1, checked);
        if (row > 0) floodFill(sea, row-1, col, checked);
        if (row < sea.length - 1 && col > 0) {
            floodFill(sea, row+1, col - 1, checked);
        }
        if (col < sea.length - 1 && row > 0) {
            floodFill(sea, row - 1, col + 1, checked);
        }
    }

}
