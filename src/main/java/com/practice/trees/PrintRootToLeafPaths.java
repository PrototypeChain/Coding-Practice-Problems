package com.practice.trees;

public class PrintRootToLeafPaths {
    Tree root;

    public void printPaths(Tree node){
        int[] path = new int[1000];
        printPaths(node, path, 0);
    }

    public void printPaths(Tree node, int[] path, int pathLen){
        if(node == null){
            return;
        }

        path[pathLen] = node.data;
        pathLen++;

        if(node.left == null && node.right == null){
            printArray(path,0, pathLen);
            System.out.println();
        }else{
            printPaths(node.left, path, pathLen);
            printPaths(node.right, path, pathLen);
        }
    }

    public void printArray(int[] path, int start , int end){
        for(int i = start; i< end; i++){
            System.out.print(path[i] + " ");
        }
    }

    public static void main(String[] args) {
        PrintRootToLeafPaths tree = new PrintRootToLeafPaths();

        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        /* Print all root-to-leaf paths of the input tree */
        tree.printPaths(tree.root);
    }
}
