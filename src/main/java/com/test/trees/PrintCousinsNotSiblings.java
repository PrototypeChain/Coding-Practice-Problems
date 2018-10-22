package com.test.trees;

public class PrintCousinsNotSiblings {
    Tree root;

    public int getLevel(Tree root, Tree target, int level){
        if(root == null){
            return 0;
        }
        if(root.data == target.data){
            return level;
        }
        int downLevel = getLevel(root.left, target, level +1);
        if(downLevel != 0){
            return downLevel;
        }
        return getLevel(root.right, target, level +1);

    }

    public void printGivenLevel(Tree root, Tree target, int level){
        if(root == null || level < 2){
            return;
        }

        if(level == 2){
            if(root.left ==target || root.right == target){
                return;
            }
            if(root.left != null){
                System.out.println(root.left.data);
            }
            if(root.right != null){
                System.out.println(root.right.data);
            }
        }else if(level > 2){
            printGivenLevel(root.left,target,level -1);
            printGivenLevel(root.right,target,level -1);
        }
    }

    public void printCousins(Tree root, Tree target){
        int level = getLevel(root,target, 1);

        printGivenLevel(root, target, level);
    }

    public static void main(String[] args) {
        PrintCousinsNotSiblings tree = new PrintCousinsNotSiblings();
        tree.root = new Tree(20);
        tree.root.left = new Tree(8);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(12); //Find cousins
        tree.root.left.right.left = new Tree(10);
        tree.root.left.right.right = new Tree(14);
        tree.root.right = new Tree(22);
        tree.root.right.right = new Tree(25);
        tree.printCousins(tree.root, tree.root.left.right);
    }
}
