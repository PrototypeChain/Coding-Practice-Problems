package com.practice.standard;

public class TrappingRainWater {

    public static int findWater(int[]arr , int n){
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMax[0] = arr[0];

        for(int i =1; i < arr.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for(int i =arr.length -2 ; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1] , arr[i]);
        }

        int water = 0;

        for(int i = 0; i <arr.length; i++){
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return water;
    }

    static int findWaterSpaceOptimized(int arr[], int n)
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n-1;

        while(lo <= hi)
        {
            if(arr[lo] < arr[hi])
            {
                if(arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else
            {
                if(arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is " + findWaterSpaceOptimized(arr, arr.length));
    }
}
