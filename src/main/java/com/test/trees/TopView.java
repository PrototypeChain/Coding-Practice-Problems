package com.test.trees;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopView {
    TreeNode root;
    public void printTopView(){
        printTopView(root);
    }

    public void printTopView(TreeNode root){

        if (root == null){
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            int hd = node.hd;

            if(!set.contains(hd)){
                System.out.println(node.data);
                set.add(hd);
            }

            if(node.left != null){
                node.left.hd = hd -1;
                q.add(node.left);
            }
            if(node.right != null){
                node.right.hd = hd +1;
                q.add(node.right);
            }
        }


    }

    public static void main(String[] args) {
        TopView tree = new TopView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.left.right.right.right = new TreeNode(6);
        tree.printTopView();
    }
}
