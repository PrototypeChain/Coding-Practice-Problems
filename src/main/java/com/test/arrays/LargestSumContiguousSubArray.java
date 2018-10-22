package com.test.arrays;

public class LargestSumContiguousSubArray {

    public static int getLargestSum(int[] arr){
        int maxSumSoFar = 0;
        int maxEndingHere = 0;

        int start = 0;
        int end = 0;
        int s = 0;
        for(int i = 0; i< arr.length; i++){
            maxEndingHere += arr[i];

            if(maxEndingHere < 0){
                maxEndingHere = 0;
                s = i + 1;
            }

            if(maxEndingHere > maxSumSoFar){
                maxSumSoFar = maxEndingHere;
                start = s;
                end = i;
            }

        }
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        return maxSumSoFar;
    }


    public static void main(String[] args) {
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSumSoFar = getLargestSum(arr);
        System.out.println("Maximum contiguous sum is " +
                maxSumSoFar);
    }
}
