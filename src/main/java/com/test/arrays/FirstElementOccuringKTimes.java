package com.test.arrays;
import java.util.*;
public class FirstElementOccuringKTimes {

    public static int getNumber(int[] arr, int k){

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(int i=0; i < arr.length; i++){
            if(map.get(arr[i]) == k){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println("Number occuring k times is"+ getNumber(arr, k));

        String a = "test";

    }
}
