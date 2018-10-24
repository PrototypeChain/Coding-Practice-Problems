package com.practice.arrays;

public class KStackArrays {

    int[] topOfStack;
    int[] stackData;
    int[] nextIndex;
    int nextAvailable = 0;

    KStackArrays(int numStacks, int capacity){
        topOfStack = new int[numStacks];
        for(int i=0; i <numStacks; i++){
            topOfStack[i] = -1;
        }
        stackData = new int[capacity];
        nextIndex = new int[capacity];
        for(int i=0; i <nextIndex.length - 1; i++){
            nextIndex[i] = i + 1;
        }
        nextIndex[nextIndex.length - 1] = -1;

    }

    public void push(int value, int stack){
        if(stack < 0  || stack >= topOfStack.length){
            throw new IndexOutOfBoundsException();
        }
        if(nextAvailable < 0){
            return;
        }
        int currentIndex = nextAvailable;
        nextAvailable = nextIndex[currentIndex];

        stackData[currentIndex] = value;

        nextIndex[currentIndex] = topOfStack[stack];
        topOfStack[stack] = currentIndex;
    }

    public int pop(int stack){
        if (stack < 0 || stack >= topOfStack.length
                || topOfStack[stack] < 0) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = topOfStack[stack];
        int value = stackData[currentIndex];
        topOfStack[stack] = nextIndex[currentIndex];
        nextIndex[currentIndex] = nextAvailable;
        nextAvailable = currentIndex;
        return value;
    }

    // Driver program
    public static void main(String[] args)
    {
        // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;

        KStackArrays ks = new KStackArrays(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
