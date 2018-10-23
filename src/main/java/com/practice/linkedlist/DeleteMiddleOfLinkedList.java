package com.practice.linkedlist;

public class DeleteMiddleOfLinkedList {

    Node head;

    public void deleteMiddleElement() {
        Node prev = null;
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        prev.next = slowPointer.next;

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
        DeleteMiddleOfLinkedList obj = new DeleteMiddleOfLinkedList();
        obj.push(21);
        obj.push(20);
        obj.push(3);
        obj.push(34);
        System.out.println("Before Linkedlist: ");
        obj.printLinkedList();

        obj.deleteMiddleElement();

        System.out.println("After Linkedlist: ");
        obj.printLinkedList();

    }
}

class Node2 {
    int data;
    Node2 next;

    Node2(int d) {
        data = d;
        next = null;
    }
}
