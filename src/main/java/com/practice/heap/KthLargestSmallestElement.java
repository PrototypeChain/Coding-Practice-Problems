package com.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;
public class KthLargestSmallestElement {

    public static int getKthLargest(int[] arr, int n, int k){
        int largest = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);

        for(int i =0; i < arr.length; i++){
            queue.add(arr[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int getKthSmallest(int[] arr, int n, int k){
        int largest = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());

        for(int i =0; i < arr.length; i++){
            queue.add(arr[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int kthLargest = getKthLargest(arr, arr.length, 3);
        int kthSmallest = getKthSmallest(arr, arr.length, 3);
        System.out.println("kTh Largest: "+ kthLargest);
        System.out.println("kTh Smallest: "+ kthSmallest);

    }
}
