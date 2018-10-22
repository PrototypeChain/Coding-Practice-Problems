package com.test.strings;

import java.util.Arrays;
import java.util.Comparator;

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
