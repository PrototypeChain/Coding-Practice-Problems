package com.practice.matrix;

public class MaxSizeSquareSubMatrixAll1s {

    public static void printMaxSubSquare(int[][] mat){
        int[][] sum = new int[mat.length][mat[0].length];

            for (int j = 0; j < mat[0].length; j++) {
                sum[0][j] = mat[0][j];
            }

        for(int i =0; i<mat.length; i++) {
                sum[i][0] = mat[i][0];
        }

        for(int i =1; i< mat.length; i++){
            for(int j=1; j< mat[0].length; j++){
                if(mat[i][j] == 1){
                    sum[i][j] =  1 + (Math.min(sum[i-1][j], Math.min(sum[i][j-1], sum[i-1][j-1])));
                }else{
                    sum[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE; int max_i = 0,max_j=0;
        for(int i =0; i<sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                if(sum[i][j] > max){
                    max = sum[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println("Maximum size sub-matrix is: ");
        for(int i = max_i; i > max_i - max; i--)
        {
            for(int j = max_j; j > max_j - max; j--)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int M[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSubSquare(M);
    }
}
