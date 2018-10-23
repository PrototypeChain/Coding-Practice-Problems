package com.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubArraySumCloset0 {

    public static void getSubarray(int[] arr) {
        List<Resultant> listArr = new ArrayList<Resultant>(arr.length + 1);
        listArr.add(0, new Resultant(0, -1));

        for (int i = 1; i < arr.length; i++) {
            listArr.add(i, new Resultant(listArr.get(i - 1).getSum() + arr[i - 1], i - 1));
        }

        Collections.sort(listArr, new Comparator<Resultant>() {
            public int compare(Resultant o1, Resultant o2) {
                if (o1.getSum() > o2.getSum()) {
                    return 1;
                } else if (o1.getSum() < o2.getSum()) {
                    return -1;
                }
                return 0;
            }
        });

        int minDiff = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 1; i < listArr.size(); i++) {
            int diff = listArr.get(i).getSum() - listArr.get(i - 1).getSum();
            if (minDiff > diff) {
                minDiff = diff;
                start = listArr.get(i - 1).getIndex();
                end = listArr.get(i).getIndex();
            }
        }

        System.out.println("Start Index: " + (start + 1) + " End Index: " + end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -4, -1, 6};
        getSubarray(arr);
    }
}

class Resultant {
    private int sum;
    private int index;

    Resultant(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }

    public int getSum() {
        return sum;
    }

    public int getIndex() {
        return index;
    }
}
