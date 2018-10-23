package com.practice.arrays;

public class MaximumDifferenceBetweenTwoElements {

    public static int getMaxDifference(int[] arr){

        int min = Integer.MAX_VALUE;
        int minDiff = Integer.MIN_VALUE;;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] - min > minDiff){
                minDiff = arr[i] - min;
            }

            if(arr[i] < min && arr[i] > -1){
                min = arr[i];
            }
        }

        return minDiff;
    }

    public static void main(String[] args){
        int[] arr = {-1, 2, 90, 10, 110};

        System.out.println("Max Difference is: " + getMaxDifference(arr) );

    }
}
