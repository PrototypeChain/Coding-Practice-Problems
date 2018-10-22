package com.test.trees;

public class PrintAncestors {

    Tree root;
    public void printAncestors(int k){
        printAncestors(root,k);
    }
    public boolean printAncestors(Tree node, int target){
        if(node == null){
            return false;
        }

        if(node.data == target){
            return true;
        }

        if(printAncestors(node.left, target) || printAncestors(node.right, target)  ){
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        PrintAncestors tree = new PrintAncestors();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        tree.root.left.left.left = new Tree(7);
        tree.printAncestors(7);
    }
}
