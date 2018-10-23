package com.practice.arrays;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");*/

        System.out.println(new Date());
/*        int[] arr = new int[10];
        Arrays.fill(arr,0);

        for(int i=0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            fillArray(arr, a , b, k);
            int max = getMaximum(arr);

          }
        */
    }

    public static void fillArray(int[] arr, int a, int b, int k) {
        for (int i = a - 1; i < b; i++) {
            arr[i] += k;
        }
    }

    public static int getMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

}
