package com.practice.heap;

import java.util.Arrays;

public class HeapSort {

    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int leftChild = 2*i +1;
        int rightChild = 2*i +2;

        if(leftChild < n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }

        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n , largest);
        }

    }

    public void buildHeap(int[] arr, int n){
       for(int i = n/2 - 1; i >=0; i--){
            heapify(arr, n, i);
        }
    }

    public void sort(int[] arr, int n){
        buildHeap(arr,n);

        for(int i = n-1; i>=0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        //int[] arr = {12, 11, 13, 5, 6, 7};
        int[] arr = {12, 6, 13, 11, 15, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, arr.length);
    }
}

