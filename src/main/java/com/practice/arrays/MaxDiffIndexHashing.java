package com.practice.arrays;

// Java implementation to find the maximum difference
// of first and last index of array elements
import java.util.HashMap;
import java.util.Map;

public class MaxDiffIndexHashing {

    static class Element {
        int first;
        int second;

        public Element() {
            super();
        }

        public Element(int first, int second) {
            super();
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        int arr[]={2, 1, 3, 4, 2, 1, 5, 1, 7};
        System.out.println("Maximum Difference= "+ maxDiffIndices(arr));
    }

    private static int maxDiffIndices(int[] arr) {
        int n = arr.length;
        int maxDiffIndex = 0;
        Map<Integer, Element> map = new HashMap<Integer, Element>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                Element e = map.get(arr[i]);
                e.second = i;
            } else {
                Element e = new Element();
                e.first = i;
                map.put(arr[i], e);
            }

        }

        for(Map.Entry<Integer,Element> entry: map.entrySet()){
            Element a = entry.getValue();
            if(a.second - a.first > maxDiffIndex){
                maxDiffIndex = a.second - a.first;
            }
        }

        return maxDiffIndex;
    }

}