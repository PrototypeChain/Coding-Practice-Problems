package com.practice.arrays;

import java.util.Arrays;

public class ArrayRotation {

    public  static  void leftRotate(int[] arr, int d){
        reverseArray(arr, 0 , d-1);
        reverseArray(arr, d , arr.length - 1);
        reverseArray(arr, 0 , arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end --;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int d = 2;
        leftRotate(arr, d);
    }
}
