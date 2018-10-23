package com.practice.trees;

public class LeftView {
    Tree root;
    int maxLevel = 0;

    public void leftView(){
        leftView(root, 1);
    }
    public void leftView(Tree node, int level){
        if(node == null){
            return;
        }
        if(level > maxLevel){
            System.out.println(node.data);
            maxLevel = level;
        }
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }

    public static void main(String[] args) {
        LeftView tree = new LeftView();
        tree.root = new Tree(12);
        tree.root.left = new Tree(10);
        tree.root.right = new Tree(30);
        tree.root.right.left = new Tree(25);
        tree.root.right.right = new Tree(40);

        tree.leftView();
    }
}
