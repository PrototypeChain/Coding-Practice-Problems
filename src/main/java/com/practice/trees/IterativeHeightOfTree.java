package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeHeightOfTree {

    Tree root;

    public int treeHeight(Tree root){
        if(root == null){
            return 0;
        }

        int height = 0;
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (true) {
            int nodeCount = queue.size();
            if(nodeCount == 0){
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Tree node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static void main(String[] args) {
        IterativeHeightOfTree tree = new IterativeHeightOfTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    }
}
