package com.practice.arrays;
//https://www.geeksforgeeks.org/find-subarray-with-given-sum/

public class SubArraySumAllPostiveNumbers {

    public static void printSubArray(int[] arr, int sum){
        int currSum = arr[0];
        int start = 0;
        int finalIndex = -1;

        for(int i = 1; i < arr.length; i++){
            currSum = currSum + arr[i];

            while (currSum > sum && start < i-1){
                currSum = currSum - arr[start];
                start++;
            }

            if(currSum == sum){
                finalIndex = i;
                System.out.println("Sum found between indexes " + start
                        + " and " + finalIndex);
                return;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        printSubArray(arr, sum);
    }
}
