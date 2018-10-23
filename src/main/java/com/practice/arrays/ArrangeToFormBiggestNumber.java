package com.practice.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class ArrangeToFormBiggestNumber {

    public static void printLargest(Vector<String> arr){
          Collections.sort(arr, new Comparator<String>(){
                public int  compare(String X, String Y){
                    String XY = X + Y;
                    String YX = Y  + X;
                    return XY.compareTo(YX) > 0 ? -1 : 1;
                }
          });

        Iterator it =  arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    public static void main(String[] args) {
        Vector<String> arr;
        arr = new Vector<String>();
        arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");

        printLargest(arr);
    }
}
