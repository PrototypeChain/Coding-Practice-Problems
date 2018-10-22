package com.test.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class TreeNode{
    int data;
    int hd;
    TreeNode left , right;
    TreeNode(int d){
        this.data = d;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class BottomView {
    TreeNode root;

    public void bottomView(){
        bottomView(root);
    }

    public void bottomView(TreeNode node){
        if(node ==null){
            return;
        }

        Map<Integer, TreeNode> map = new TreeMap<Integer, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        node.hd = 0;
        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode tnode = queue.poll();

            if(tnode.left != null){
                tnode.left.hd = tnode.hd -1;
                queue.add(tnode.left);
            }
            if(tnode.right != null){
                tnode.right.hd = tnode.hd + 1;
                queue.add(tnode.right);
            }
            map.put(tnode.hd, tnode);
        }

        Set<Map.Entry<Integer, TreeNode>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, TreeNode>> itr = entrySet.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next().getValue().data);
        }

    }

    public static void main(String[] args) {
        BottomView tree = new BottomView();
        tree.root = new TreeNode(12);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(25);
        tree.root.right.right = new TreeNode(40);

        tree.bottomView();
    }
}
