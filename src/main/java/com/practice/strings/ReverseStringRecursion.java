package com.practice.strings;

public class ReverseStringRecursion {

    public static void getReverseString(char[] str, int start, int end){
        if(end == start){
            System.out.print(str[end]);
        }
        System.out.print(str[end]);
        getReverseString(str, 0, end -1);
    }

    public static void main(String[] args){
        String str = "geeksforgeeks";
        StringBuilder result = new StringBuilder();
        getReverseString(str.toCharArray(), 0, str.length() -1);
    }
}
