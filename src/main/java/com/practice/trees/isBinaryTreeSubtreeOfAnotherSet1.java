package com.practice.trees;


public class isBinaryTreeSubtreeOfAnotherSet1 {

    Tree root1, root2;

    boolean areIdentical(Tree root1, Tree root2)
    {

        /* base cases */
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.data == root2.data
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Tree T, Tree S)
    {
        /* base cases */
        if (S == null)
            return true;

        if (T == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(T, S))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
    }

    public static void main(String[] args) {
        isBinaryTreeSubtreeOfAnotherSet1 tree = new isBinaryTreeSubtreeOfAnotherSet1();
        tree.root1 = new Tree(26);
        tree.root1.right = new Tree(3);
        tree.root1.right.right = new Tree(3);
        tree.root1.left = new Tree(10);
        tree.root1.left.left = new Tree(4);
        tree.root1.left.left.right = new Tree(30);
        tree.root1.left.right = new Tree(6);

        tree.root2 = new Tree(10);
        tree.root2.right = new Tree(6);
        tree.root2.left = new Tree(4);
        tree.root2.left.right = new Tree(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");


    }
}
