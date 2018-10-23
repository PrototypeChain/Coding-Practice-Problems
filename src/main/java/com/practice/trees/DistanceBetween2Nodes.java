package com.practice.trees;

public class DistanceBetween2Nodes {

    Tree root;

    public int getDistance(Tree node, int n1, int n2){
        Tree lcaNode = lca(node, n1, n2);
        int x = pathLength(node, n1) - 1;
        int y = pathLength(node, n2) -1 ;
        int lcaDistance = pathLength(node, lcaNode.data) - 1;

        return (x + y) - (2*lcaDistance);
    }

    public int pathLength(Tree root, int n1){
        if(root != null){
            int x = 0;
            if((root.data == n1) || (x = pathLength(root.left, n1)) > 0 ||
                    (x = pathLength(root.right, n1)) > 0){
                return x +1;
            }
            return 0;
        }
        return 0;
    }

    public Tree lca(Tree node, int n1, int n2){

        if(node == null){
            return null;
        }

        if(node.data == n1 || node.data == n2){
            return node;
        }
        Tree left = lca(node.left, n1, n2);
        Tree right = lca(node.right, n1, n2);
        if(left != null && right != null){
            return node;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        DistanceBetween2Nodes tree = new DistanceBetween2Nodes();
        Tree root = new Tree(5);
        root.left = new Tree(10);
        root.right = new Tree(15);
        root.left.left = new Tree(20);
        root.left.right = new Tree(25);
        root.right.left = new Tree(30);
        root.right.right = new Tree(35);
        root.left.right.right = new Tree(45);
        tree.root = root;

        System.out.println("Distance: "+ tree.getDistance(tree.root, 45, 20));
    }
}
