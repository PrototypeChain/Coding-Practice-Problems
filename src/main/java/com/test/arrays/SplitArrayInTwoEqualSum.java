package com.test.arrays;

public class SplitArrayInTwoEqualSum {

    public int splitArray(int[] arr){
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < arr.length; i++){
            leftSum += arr[i];
        }

        for(int j = arr.length-1; j >=0 ; j--){
            rightSum += arr[j];
            leftSum = leftSum - arr[j];

            if(leftSum == rightSum){
                return j;
            }
        }
        return -1;
    }

    public void printTwoHalves(int[] arr, int splitPointer){
        for(int i = 0; i < arr.length; i++){
            if(i == splitPointer){
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5 , 5};
        SplitArrayInTwoEqualSum obj = new SplitArrayInTwoEqualSum();
        int splitPointer = obj.splitArray(arr);
        if(splitPointer != -1 || splitPointer == arr.length){
            obj.printTwoHalves(arr, splitPointer);
        }else{
            System.out.println("Two halves of equal sum don't exists");
        }
    }
}
