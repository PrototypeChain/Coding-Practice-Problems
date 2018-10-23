package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class ArrayWrapper implements Comparable<ArrayWrapper>{
    int[] arr;
    int index;
    ArrayWrapper(int[] arr, int index){
        this.arr = arr;
        this.index = index;
    }

    public int compareTo(ArrayWrapper o){
        return this.arr[this.index] - o.arr[o.index];
    }
}

public class MergeKSortedArrays {

    public static void mergeKSortedArrays(int[][] arr){

        PriorityQueue<ArrayWrapper> queue = new PriorityQueue<ArrayWrapper>();
        int totalLen = 0;

        for(int i =0; i< arr.length; i++){
            queue.add(new ArrayWrapper(arr[i], 0));
            totalLen = totalLen + arr[i].length;
        }

        int m = 0;
        int result[] = new int[totalLen];

        while (!queue.isEmpty()){
            ArrayWrapper wrapper = queue.poll();
            result[m++] = wrapper.arr[wrapper.index];
            if (wrapper.index < wrapper.arr.length - 1){
                queue.add(new ArrayWrapper(wrapper.arr, wrapper.index + 1));
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };
        List<Integer>[] seqList = new ArrayList[2];
        mergeKSortedArrays(new int[][]{arr1, arr2 ,arr3});
    }
}
