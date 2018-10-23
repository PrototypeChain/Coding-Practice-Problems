package com.practice.matrix;

public class CountSortedRows {

    public int getSortedRows(int mat[][]){
        int result = 0;
        for(int i=0; i < mat.length; i++){
            int j;
            for(j=0; j < mat[0].length - 1; j++){
                if(mat[i][j+1] <= mat[i][j]){
                    break;
                }
            }
            if(j == mat[0].length - 1){
                result++;//Decreasing Order
            }
        }
        for(int i=0; i < mat.length; i++){
            int j;
            for(j=0; j < mat[0].length - 1; j++){
                if(mat[i][j+1] >= mat[i][j]){
                    break;
                }
            }
            if(j == mat[0].length - 1){
                result++;//Increasing  Order
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        CountSortedRows obj = new CountSortedRows();
        int mat[][] = { { 1, 2, 3, 4, 5 },
                { 4, 3, 1, 2, 6 },
                { 8, 7, 6, 5, 4 },
                { 5, 7, 8, 9, 10 } };
        System.out.println(" Count: " + obj.getSortedRows(mat));
    }
}
