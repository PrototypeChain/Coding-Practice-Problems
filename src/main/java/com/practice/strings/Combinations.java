package com.practice.strings;

public class Combinations {
    private StringBuilder output = new StringBuilder();

    public static void main(String args[]) {
        Combinations combobj = new Combinations();
        String inputString = "ABCD";
        System.out.println("Possible Combinations: ");
        combobj.combine(inputString);
    }

    public void combine(String inputString) {
        combine(inputString, 0);
    }

    private void combine(String str, int start) {
        for (int i = start; i < str.length(); ++i) {
            output.append(str.charAt(i));
            System.out.println(output);
            if (i < str.length()){
                combine(str, i + 1);
            }
            output.setLength(output.length() - 1);
        }
    }
}
