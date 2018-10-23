package com.practice.linkedlist;

class Node1{
    int data;
    Node next;
    Node1(int d){
        data = d;
        next = null;
    }
}

public class MiddleOfLinkedList {
    Node head;


    public void push(int new_data){
        Node node = new Node(new_data);
        node.next = head;
        head = node;
    }

    public void getMiddleElement(){
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null  && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println(slowPointer.data);
    }

    public static void main(String[] args) {
        MiddleOfLinkedList obj = new MiddleOfLinkedList();
        obj.push(21);
        obj.push(20);
        obj.push(3);
        obj.push(34);
        obj.getMiddleElement();
    }
}
