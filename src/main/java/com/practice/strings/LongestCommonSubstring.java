package com.practice.strings;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static int find(char [] A, char [] B){
        int[][] lcs = new int[A.length + 1][B.length +1];

        for(int i=0;i<=B.length;i++){
            lcs[0][i]=0;
        }

        // if B is null then LCS of A, B =0
        for(int i=0;i<=A.length;i++){
            lcs[i][0]=0;
        }

        for(int i=1;i<=A.length;i++) {
            for (int j = 1; j <=B.length; j++) {
                if(A[i-1] == B[j-1]){
                    lcs[i][j] =  lcs[i-1][j-1] +1;
                }else{
                    lcs[i][j] = 0;
                }
            }
        }

        int result = -1;
        for(int i=0;i<=A.length;i++){
            for(int j=0;j<=B.length;j++){
                if(result<lcs[i][j]){
                    result = lcs[i][j];
                }
            }
        }

        return result;
    }

    public static int getSubstringUsingRecursion(char[] str1, char[] str2, int m, int n, int count ){
        if(m == 0 || n ==0){
            return count;
        }

        if(str1[m-1] == str2[n-1]){
            count = getSubstringUsingRecursion(str1, str2, m-1, n-1, count + 1);
        }
        else{
            count = Math.max(count,
                        Math.max(getSubstringUsingRecursion(str1, str2, m-1, n, 0),
                            getSubstringUsingRecursion(str1, str2, m, n-1, 0) )
                    );
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "abcdxyz";
        String B = "testxyz";
        System.out.println("Longest Common Substring using DP is: " + find(A.toCharArray(), B.toCharArray()));

        System.out.println("Longest Common Substring using Recursion is: " +
                getSubstringUsingRecursion(A.toCharArray(), B.toCharArray(), A.length(), B.length(), 0));

    }
}
