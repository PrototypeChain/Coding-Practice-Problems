package com.test.trees;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SizeOfTree {
    Tree root;

    public int size() {
        return size(root);
    }

    public int size(Tree root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static void main(String[] args) {
        SizeOfTree tree = new SizeOfTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        System.out.println("The size of binary tree is : "
                + tree.size());
    }
}
