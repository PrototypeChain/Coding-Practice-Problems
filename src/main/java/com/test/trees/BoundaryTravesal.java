package com.test.trees;

public class BoundaryTravesal {
    Tree root;

    public void printBoundaryLeft(Tree node){
        if(node == null)
        { return; }

        if(node.left != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }else if(node.right != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }

    public void printAllLeaves(Tree node){
        if(node == null){ return; }

        printAllLeaves(node.left);

        if(node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }

        printAllLeaves(node.right);

    }

    public void printBoundaryRight(Tree node){
        if(node == null){
            return;
        }

        if(node.right != null){
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }else if(node.left != null){
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }

    public void printBoundary(Tree node){
          if(node != null){
              System.out.print(node.data + " ");
              printBoundaryLeft(node.left);

              printAllLeaves(node.left);
              printAllLeaves(node.right);

              printBoundaryRight(node.right);
          }
    }

    public static void main(String[] args) {
        BoundaryTravesal tree = new BoundaryTravesal();
        tree.root = new Tree(20);
        tree.root.left = new Tree(8);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(12);
        tree.root.left.right.left = new Tree(10);
        tree.root.left.right.right = new Tree(14);
        tree.root.right = new Tree(22);
        tree.root.right.right = new Tree(25);
        tree.printBoundary(tree.root);
    }
}
