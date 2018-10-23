package com.practice.bst;

class Tree{
    int data;
    Tree left, right;
    Tree(int d){
        this.data = d;
        left = right = null;
    }
}
public class CheckBST {
    Tree root;

    public boolean checkIsBST(Tree node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.data <= min || node.data >= max){
            return false;
        }

        return (checkIsBST(node.left, min, node.data) &&
                checkIsBST(node.right, node.data, max));
    }

    public static void main(String[] args) {
        CheckBST tree = new CheckBST();
        tree.root = new Tree(4);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(5);
        tree.root.left.left = new Tree(1);
        tree.root.left.right = new Tree(3);
        boolean isBst = tree.checkIsBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("IS bst: "+ isBst);

    }
}
