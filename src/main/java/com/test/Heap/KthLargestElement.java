package com.test.Heap;

import java.util.PriorityQueue;
public class KthLargestElement {

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

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int kthLargest = getKthLargest(arr, arr.length, 2);
        System.out.println("kTh Largest: "+ kthLargest);

    }
}
