package com.test.strings;

public class MaxOccuringCharacter {

    public static char getMaxOccuringChar(String str){

        int[] count = new int[256];
        for(int i=0; i< str.length(); i++){
            count[str.charAt(i)]++;
        }
        int max = Integer.MIN_VALUE;
        char c= ' ';
        for(int i=0; i<str.length(); i++){
            if( max < count[str.charAt(i)]){
                max = count[str.charAt(i)];
                c = str.charAt(i);
            }
        }
        return c;
    }

    public static void main(String[] args){
        String str = "sample string";
        System.out.println("Max occuring character is: " + getMaxOccuringChar(str));
    }

}
