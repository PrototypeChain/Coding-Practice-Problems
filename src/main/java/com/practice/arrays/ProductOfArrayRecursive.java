package com.practice.arrays;

public class ProductOfArrayRecursive {

    public static int printProduct(int[] arr, int start, int end){

        if(start == end){
            return arr[end];
        }

        return arr[start] * printProduct(arr, start+1, end);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(printProduct(arr, 0, arr.length -1 ));


    }
}
