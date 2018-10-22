package com.test.strings;

public class PrintAllPermutations {

    public static void printPermutations(String str, int l, int r){
        if(l ==r ){
            System.out.println(str);
        }

        for(int i=l; i < str.length(); i++){
            str = swap(str, l , i);
            printPermutations(str, l+1, r);
            str = swap(str, l , i);
        }
    }

    public static String swap(String str, int i, int j){
        char[] charArray = str.toCharArray();
        char temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);

    }

    public static void main(String[] args){
        String str = "ABC";
        printPermutations(str,0 ,str.length());
    }
}
