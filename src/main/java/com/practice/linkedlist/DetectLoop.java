package com.practice.linkedlist;

public class DetectLoop {
    Node head;

    public boolean detectLoop() {
        Node slow_Pointer = head;
        Node fast_Pointer = head;

        while (fast_Pointer != null && fast_Pointer.next != null){
            slow_Pointer = slow_Pointer.next;
            fast_Pointer = fast_Pointer.next.next;

            if(slow_Pointer == fast_Pointer){
                return true;
            }
        }
        return  false;
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
        DetectLoop llist = new DetectLoop();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        System.out.println("Before Linkedlist: ");
        //llist.printLinkedList();

        if(llist.detectLoop()) {
            System.out.println("Loop Found.");
        }else{
            System.out.println("Loop Not Found.");
        }


    }
}
