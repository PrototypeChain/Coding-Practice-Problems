package com.practice;

class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        this.data = d;
        left = right = null;
    }
}
public class PrintNodesNoSiblings {
    Tree root;

    public void printNodesNoSiblings(Tree node){
        if(node == null){
            return;
        }

        if(node.left != null && node.right != null){
            printNodesNoSiblings(node.left);
            printNodesNoSiblings(node.right);
        }else if (node.right != null){
            System.out.print(node.right.data + " ");
            printNodesNoSiblings(node.right);
        }else if (node.left != null){
            System.out.print(node.left.data + " ");
            printNodesNoSiblings(node.left);
        }
    }

    public static void main(String[] args) {
        PrintNodesNoSiblings tree = new PrintNodesNoSiblings();

        /* Let us construct rthe tree shown in above diagram */
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.right = new Tree(4);
        tree.root.right.left = new Tree(5);
        tree.root.right.left.right = new Tree(6);
        tree.printNodesNoSiblings(tree.root);
    }
}
