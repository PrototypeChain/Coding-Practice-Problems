package com.practice.trees;

public class Diameter {
    Tree root;

    public int getDiameter(Tree node){
        if(node == null){
            return 0;
        }

        int leftDiameter = getDiameter(node.left);
        int rightDiameter = getDiameter(node.right);

        int rootDiameter = 1 + getHeight(root.left) + getHeight(root.right);

        return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
    }

    public int getHeight(Tree node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(getHeight(node.left),getHeight(node.right));
    }

    public static void main(String[] args) {
        Diameter tree = new Diameter();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        System.out.println("Diameter: "+ tree.getDiameter(tree.root));
    }

}
