package com.practice.arrays;

import java.util.Arrays;

public class QueriesCountArraysGivenRange {

    public static int lowerBouund(int[] arr, int n, int target){
        int low = 0; int high = n -1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return low;
    }

    public static int upperBouund(int[] arr, int n, int j){
        int low = 0; int high = n -1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > j){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return low;
    }

    public static int countInRange(int[] arr, int n , int i , int j){
        int count = 0;
        count = upperBouund(arr, n , j) - lowerBouund(arr, n , i)  +1 ;
        return  count;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 4, 9, 10, 3 };
        int n = arr.length;

        Arrays.sort(arr);

        System.out.println( countInRange(arr, n, 1, 4)); ;

    }
}
