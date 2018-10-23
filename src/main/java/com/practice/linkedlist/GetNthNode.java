package com.practice.linkedlist;

class Node{
    int data;
    Node next;
    Node(int d){
       data = d;
        next = null;
    }
}

public class GetNthNode {
    Node head;

    public int getNthNode(int n){
        Node current = head;
        int count = 0;
        while (current != null){
            if(count == n){
                return current.data;
            }
            count++;
            current = current.next;
        }
        return  0;
    }

    public void push(int new_data){
        Node node = new Node(new_data);
        node.next = head;
        head = node;
    }

    public static void main(String[] args) {
        GetNthNode nthNode = new GetNthNode();
        nthNode.push(21);
        nthNode.push(20);
        nthNode.push(3);
        nthNode.push(34);
        System.out.println("Element at index 3 is "+ nthNode.getNthNode(3));
    }
}
