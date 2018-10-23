package com.practice.strings;

public class PrintAllSubstring {

    public static void main(String[] args) {
        char[] str = "abc".toCharArray();

int n = str.length;
        for(int i=1; i<=str.length; i++){
            for(int j=0; j<= n - i; j++){
                int len = j + i - 1;
                for (int k = j; k <= len; k++)
                {
                    System.out.print(str[k]);
                }
                System.out.println();
            }
        }
    }
}
