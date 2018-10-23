package com.practice.arrays;

public class FindNumberOfZeros {

    public static int countZeros(int[] arr, int low , int high){
        if(high >= low){
            int mid = low + (high - low) / 2;

            if((mid == 0 || arr[mid - 1] == 1) && arr[mid] ==0 ){
                return mid;
            }

            if(arr[mid] == 1){
                return countZeros(arr, mid +1, high);
            }else{
                return countZeros(arr, low, mid -1);
            }

        }
        return -1;
    }

    public static int printNumberOfZeros(int[] arr){
        int first = countZeros(arr, 0 , arr.length-1);
        if(first == -1){
            return 0;
        }else{
            return arr.length - first;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 1, 1, 0, 0};
        int count = printNumberOfZeros(arr);
        System.out.println(count);
    }
}
