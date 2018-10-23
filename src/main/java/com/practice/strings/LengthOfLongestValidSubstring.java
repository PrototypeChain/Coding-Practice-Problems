package com.practice.strings;

import java.util.Stack;

public class LengthOfLongestValidSubstring {

    public static int getLength(String str){
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "((()()";
        int length = getLength(str);
        System.out.println("Longest Valid Substring: "+length);

    }
}
