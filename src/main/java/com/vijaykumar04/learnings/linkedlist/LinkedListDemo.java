package com.vijaykumar04.learnings.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedListWrapper linkedListWrapper = new LinkedListWrapper();
        linkedListWrapper.insertLast("1");
        linkedListWrapper.insertLast("2");
        linkedListWrapper.insertLast("3");
        linkedListWrapper.insertLast("4");
        linkedListWrapper.insertLast("5");
        linkedListWrapper.insertFirst("0");
        linkedListWrapper.insertFirst("-1");
        linkedListWrapper.insertFirst("-2");
        linkedListWrapper.insertFirst("-3");
        linkedListWrapper.display();
    }
}

class LinkedListWrapper {

    /**
     * Definition of Node class
     */
    private class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }
    //Head node definition
    private Node head;

    /**
     * Travers the linked list to tail and append the new node. Time complexity of this operation is o(n).
     * Where n is number of elements in the list
     * @param data
     */
    public void insertLast(String data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node localHead = head;
        while (localHead.next != null) {
            localHead = localHead.next;
        }
        Node node = new Node(data);
        localHead.next = node;
    }

    /**
     * Insert the data at first node and make this node as head.
     * @param data
     */
    public void insertFirst(String data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /**
     * Insert the data after the given node.
     * @param data
     * @param prevNode
     */
    public void insertAfter(String data, Node prevNode){
        if(prevNode == null){
            throw new IllegalArgumentException("Invalid node");
        }
        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
    }
    /**
     * Traverse the list to tail and print each element to console.
     */
    public void display() {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
