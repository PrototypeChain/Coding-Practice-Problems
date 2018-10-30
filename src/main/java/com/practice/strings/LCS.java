package com.practice.strings;

public class LCS {

    public static int getSubsequence(String str1, String str2){

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] lcs = new int[arr1.length + 1][arr2.length + 1];
        String[][] solution = new String[arr1.length + 1][arr2.length + 1];

        for(int i = 0; i < str1.length(); i++){
            lcs[i][0] = 0;
            solution[i][0] = "0";
        }

        for(int i = 0; i < str2.length(); i++){
            lcs[0][i] = 0;
            solution[0][i] = "0";
        }

        for(int i =1; i <= str1.length(); i++){
            for(int j =1; j <= str2.length(); j++){
                if(arr1[i-1] == arr2[j-1]){
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                    solution[i][j] = "diagonal";
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    if(lcs[i][j] == lcs[i-1][j]){
                        solution[i][j] = "top";
                    }else{
                        solution[i][j] = "left";
                    }
                }
            }
        }

        String x = solution[str1.length()][str2.length()];
        String answer = "";
        int a = str1.length();
        int b = str2.length();
        while(x != "0"){
            if(solution[a][b] == "diagonal"){
                answer = arr1[a -1] + answer;
                a--;
                b--;
            }else if(solution[a][b] == "left"){
                b--;
            }else if(solution[a][b] == "top") {
                a--;
            }
            x = solution[a][b];
        }
        System.out.println("LCS: "+ answer);
        return lcs[str1.length()][str2.length()];
    }

    public static int getSubsequenceUsingRecursion(char[] str1, char[] str2, int m, int n){

        if(m == 0 || n ==0){
            return 0;
        }
        if (str1[m-1] == str2[n-1])
            return 1 + getSubsequenceUsingRecursion(str1, str2, m-1, n-1);
        else
            return Math.max(getSubsequenceUsingRecursion(str1, str2, m, n-1),
                    getSubsequenceUsingRecursion(str1, str2, m-1, n) );
    }

    public static void main(String[] args) {
        String A = "ACBDEA";
        String B = "ABCDA";
        System.out.println("Longest Common Subsequence is: " + getSubsequence(A, B));
        System.out.println("Longest Common Subsequence using Recursion is: " + getSubsequenceUsingRecursion(A.toCharArray(), B.toCharArray(), A.length(), B.length()));
    }
}
