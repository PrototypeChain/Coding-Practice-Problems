package com.test.tryout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LazyInitialization {

    private static boolean initialized = false;

 /*   static {
        Thread t = new Thread(new Runnable() {
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {

        List<Object> listA = new ArrayList<Object>();
        listA.add("abc");

        if(listA.contains("abc")){
            System.out.println("Matched");
        }


    }
}
