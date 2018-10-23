package com.practice.strings;

import java.util.PriorityQueue;

public class RearrangeCharactersNoTwoAdjacentAreSame {

    public static void rearrangeChars(String str){
        char[] arr = new char[26];

        for(char c: str.toCharArray()){
                arr[c - 'a'] +=  1;
        }

        PriorityQueue<MyPair> queue = new PriorityQueue<MyPair>();

        for(int i = 0; i < 26; i++){
            MyPair pair = new MyPair();
            pair.count = arr[i];
            pair.letter = (char) (i + 'a');
            queue.add(pair);
        }

        StringBuilder result = new StringBuilder();
        MyPair prev = null;
        while (!queue.isEmpty()){
            MyPair tmp = prev;
            MyPair pair = queue.poll();
            if(pair.count == 0){
                break;
            }
            pair.count = pair.count - 1;
            result.append(pair.letter);
            if(tmp != null){
                queue.add(tmp);
            }
            prev = pair;
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        String str  = "bbbaa";
        rearrangeChars(str);
    }
}

class MyPair implements Comparable<MyPair>{
    int count;
    char letter;

    public int compareTo(MyPair o){
        return this.count < o.count ? 1 : -1;
    }
}
