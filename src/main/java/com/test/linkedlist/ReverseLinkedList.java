package com.test.linkedlist;

public class ReverseLinkedList {
    Node head;


    public void reverseLinkedList(){
        Node prev = null;
        reverseLinkedList(head, prev);
    }

    public Node reverseLinkedList(Node current, Node prev){

        if (current.next == null){
            head = current;
            current.next = prev;
            return head;
        }
        Node next1  = current.next;
        current.next = prev;
        reverseLinkedList(next1, current);
        return head;
    }

    public Node reverseLinkedListIterative(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
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
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.push(21);
        obj.push(20);
        obj.push(3);
        obj.push(34);
        System.out.println("Before Linkedlist: ");
        obj.printLinkedList();
        obj.reverseLinkedList();
        System.out.println("After Linkedlist: ");
        obj.printLinkedList();
    }
}
