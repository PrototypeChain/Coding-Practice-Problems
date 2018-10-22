package com.test.strings;

public class RemoveAdjacentDuplicates {

    public static String getString(char[] strArr){
        int k = 0;
        char prev = '\0';
        for(int i=0 ; i<strArr.length; i++){
            if(prev != strArr[i]){
                strArr[k++] = strArr[i];
                prev = strArr[i];
            }
        }
        return new String(strArr).substring(0,k);
    }

    public static void main(String[] args) {
        String str = "AAABBCDDD";
        System.out.println("String after adj duplicates removal: "+ getString(str.toCharArray()));
    }
}
