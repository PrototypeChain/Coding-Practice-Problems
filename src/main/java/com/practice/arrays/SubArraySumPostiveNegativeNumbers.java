package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumPostiveNegativeNumbers {

    public static void printSubArray(int[] arr, int sum){

        int currSum = 0;
        int start = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i<arr.length; i++){
            currSum += arr[i];

            if(currSum == sum){
                System.out.println("Sum found between indexes " + start
                        + " and " + i);
                return;
            }

            if(map.containsKey(currSum - sum)){
                System.out.println("Sum found between indexes " +
                        map.get(currSum - sum)  + 1
                        + " and " + i);
                return;
            }

            map.put(currSum, i);
        }
    }

    public static void main(String[] args) {
        int[] arr =  {10, 2, -2, -20, 10};
        int sum = -10;
        printSubArray(arr, sum);
    }
}
