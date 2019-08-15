package com.practice.strings;

import java.util.*;

public class PrintAllAnagramsTogether {

    public static void printAllAnagramsTogether(String[] strArr){
        Word[] dupArr = new Word[strArr.length];

        for(int i = 0; i < strArr.length; i++){
            dupArr[i] = new Word(i, strArr[i]);
        }

        //Sort each word
        for(int i = 0; i < dupArr.length; i++){
            char[] word = dupArr[i].word.toCharArray();
            Arrays.sort(word);
            dupArr[i].word = new String(word);
        }

        //Sort the array now
        Arrays.sort(dupArr, new Comparator<Word>(){
            public int compare(Word o1, Word o2){
                return o1.word.compareTo(o2.word);
            }
        });

        for(int i = 0; i < dupArr.length; i++){
            System.out.print(strArr[dupArr[i].index] + " " );

            if(i+1 < dupArr.length && dupArr[i].word.compareTo(dupArr[i+1].word) != 0){
                System.out.println();
            }
        }
    }


    //Approach 1: Categorize by Sorted String
    /*Intuition
        Two strings are anagrams if and only if their sorted strings are equal.
        Algorithm
        Maintain a map ans : {String -> List} where each key \text{K}K is a sorted string, and each value is the list of strings from the initial input that when sorted, are equal to \text{K}K.

        In Java, we will store the key as a string, eg. code. In Python, we will store the key as a hashable tuple, eg. ('c', 'o', 'd', 'e').
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    //**Approach 2: Categorize by Count
    //Intuition
    //
    //Two strings are anagrams if and only if their character counts (respective number of occurrences of each character) are the same.
    //
    //Algorithm
    //
    //We can transform each string \text{s}s into a character count, \text{count}count, consisting of 26 non-negative integers representing the number of \text{a}a's, \text{b}b's, \text{c}c's, etc. We use these counts as the basis for our hash map.
    //
    //In Java, the hashable representation of our count will be a string delimited with '#' characters. For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total. In python, the representation will be a tuple of the counts. For example, abbccc will be (1, 2, 3, 0, 0, ..., 0), where again there are 26 entries total.
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        printAllAnagramsTogether(wordArr);
    }
}

class Word{
    int index;
    String word;

    Word(int index, String word){
        this.index = index;
        this.word = word;
    }
}
