package com.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    public static double[] getMedian(int[] array){
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(
                10,Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        double[] median = new double[array.length];

        for(int i=0; i < array.length; i++){
            int number = array[i];
            addNumber(lowers, highers, number);
            rebalance(lowers, highers);
            median[i] = getMedian(lowers, highers);

        }

        return median;
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> bigHeap = lowers.size() > highers.size() ? lowers: highers;
        PriorityQueue<Integer> smallHeap = lowers.size() > highers.size() ? highers: lowers;

        if(bigHeap.size() == smallHeap.size()){
            return ((double) bigHeap.peek() + smallHeap.peek()) /2.0;
        }else{
            return bigHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> bigHeap = lowers.size() > highers.size() ? lowers: highers;
        PriorityQueue<Integer> smallHeap = lowers.size() > highers.size() ? highers: lowers;

        if(bigHeap.size() - smallHeap.size() >= 2){
            smallHeap.add(bigHeap.poll());
        }
    }

    private static void addNumber(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers, int number) {
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        }else{
            highers.add(number);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        double[] median = getMedian(arr);
        for(double num : median){
            System.out.print(num + " ");
        }
    }
}
