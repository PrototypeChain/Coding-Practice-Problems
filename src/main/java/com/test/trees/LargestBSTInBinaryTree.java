package com.test.trees;

class Wrapper{
    int upper = Integer.MIN_VALUE;
    int lower = Integer.MAX_VALUE;
    int size = 0;
    boolean isBST = false;
}
public class LargestBSTInBinaryTree {
    Tree root;

    public Wrapper getLargestBST(Tree node){
        Wrapper curr = new Wrapper();


        if(node == null){
            curr.isBST = true;
            return curr;
        }

        if(node.left == null && node.right == null){
            curr.size =1;
            curr.isBST = true;
            return curr;
        }

        Wrapper l = getLargestBST(node.left);
        Wrapper r = getLargestBST(node.right);

        curr.lower = Math.min(node.data, l.lower);
        curr.upper = Math.max(node.data, l.upper);


        if(l.isBST && r.isBST && curr.upper <= node.data && curr.lower >= node.data  ){
            curr.isBST = true;
            curr.size = l.size + r.size + 1;
        }else{
            curr.isBST = false;
            curr.size = Math.max(l.size, r.size);
        }

        return curr;
    }

    /*public int getLargestBST(Tree root){
        return 0;
    }*/

    public static void main(String[] args) {
        LargestBSTInBinaryTree tree = new LargestBSTInBinaryTree();
        tree.root = new Tree(60);
        tree.root.left = new Tree(65);
        tree.root.right = new Tree(70);
        tree.root.left.left = new Tree(50);
        System.out.println("Largest BST: "+ tree.getLargestBST(tree.root).size);
    }
}
