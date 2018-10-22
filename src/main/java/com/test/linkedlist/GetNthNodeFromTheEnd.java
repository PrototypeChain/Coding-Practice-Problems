package com.test.linkedlist;

public class GetNthNodeFromTheEnd {
    Node head;

    public int getNodeFromTheEnd(int n){
        Node slowPointer = head;
        Node fastPointer = head;

        while (n != 0){
            fastPointer = fastPointer.next;
            n--;
        }

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        if (current == null) {
            System.out.print("NULL");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GetNthNodeFromTheEnd obj = new GetNthNodeFromTheEnd();
        obj.push(21);
        obj.push(20);
        obj.push(3);
        obj.push(34);
        System.out.println("Before Linkedlist: ");
        obj.printLinkedList();

        int n = 2;
        int data= obj.getNodeFromTheEnd(n);

        System.out.println("Node from end: "+ data);
        obj.printLinkedList();

    }
}
