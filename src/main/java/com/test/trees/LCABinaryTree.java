package com.test.trees;

public class LCABinaryTree {

    Tree root;

    public Tree lca(Tree node, int n1 , int n2){
        if(node == null){
            return null;
        }

        if(node.data == n1 || node.data == n2){
            return node;
        }
        Tree leftNode = lca(node.left, n1, n2);
        Tree rightNode = lca(node.right, n1, n2);

        if(leftNode != null && rightNode != null){
            return node;
        }

        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String args[]) {
        // Let us construct the BST shown in the above figure
        LCABinaryTree tree = new LCABinaryTree();
        tree.root = new Tree(20);
        tree.root.left = new Tree(8);
        tree.root.right = new Tree(22);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(12);
        tree.root.left.right.left = new Tree(10);
        tree.root.left.right.right = new Tree(14);

        int n1 = 10, n2 = 14;
        Tree t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }
}
