package com.test.trees;

public class HeightOfTree {

    Tree root;

    public int getHeight(){
       //return getHeight(root, 1);
        return maxDepth(root);
    }

    public int getHeight(Tree root, int level){

        if(root == null){
           return level;
        }
        int leftHeight = getHeight(root.left, level +1 );
        int righttHeight = getHeight(root.right, level +1 );
        return Math.max(leftHeight,righttHeight);

    }

    int maxDepth(Tree node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static void main(String[] args) {
        HeightOfTree tree = new HeightOfTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        System.out.println("Height: "+ tree.getHeight());
    }
}

class Tree1{
    int data;
    Tree1 left, right;
    Tree1(int data){
        this.data = data;
        left = right = null;
    }
}
