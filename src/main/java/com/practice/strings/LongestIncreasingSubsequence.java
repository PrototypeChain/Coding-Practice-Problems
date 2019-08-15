package com.practice.strings;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    //Recursive Solution - LeetCode - Length of LIS
    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    //DP Solution
    public static int getLis(int[] arr){
        int[] LIS = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            LIS[i] = 1;
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                    if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1){
                        LIS[i] = 1 +  LIS[j];
                    }
            }
        }
        int max = 0;
        int index = -1;
        for(int i = 0; i < arr.length; i++){
                if(max < LIS[i]){
                    max = LIS[i];
                    index = i;
                }
        }

        String path = arr[index] + " ";
        int res = max -1;

        for(int i =  index; i >= 0 ; i--){
            if(LIS[i] == res){
                path =  arr[i] + " " + path;
                res = res -1 ;
            }
        }
        System.out.println("Actual Elements: " + path);
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis  = new LongestIncreasingSubsequence();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

        int len = getLis(arr);
        System.out.println(len);

        System.out.println("Recursion: " + lis.lengthOfLIS(arr));
    }
}
