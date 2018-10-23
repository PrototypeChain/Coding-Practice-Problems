package com.practice.trees;

public class RightView {
    Tree root;
    static int maxLevel= 0;
    public void rightView(){
        rightView(root, 1);
    }

    public void rightView(Tree node, int level){
        if(node == null){
            return;
        }
        if(maxLevel < level){
            System.out.println(node.data);
            maxLevel = level;
        }
        rightView(node.right, level + 1);
        rightView(node.left, level + 1);
    }

    public static void main(String[] args) {
        RightView tree = new RightView();
        tree.root = new Tree(12);
        tree.root.left = new Tree(10);
        tree.root.right = new Tree(30);
        tree.root.right.left = new Tree(25);
        tree.root.right.right = new Tree(40);

        tree.rightView();
    }
}
