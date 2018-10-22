package com.test.matrix;

public class Count0sBinaryMatrixSorted {

    public static int countZeroes(int[][] mat){

        int col = mat[0].length - 1;
        int row = 0;

        int count = 0;
        while (row < mat.length){
            while (col >= 0){
                if(mat[row][col] == 1){
                    col--;
                }else{
                    count += col +1;
                    row++;
                    break;
                }
            }
        }

        System.out.println("Count: "+ count);
        return 0;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 } };
        System.out.println(countZeroes(mat));

    }
}
