import java.util.*;

// Implementation of singly linkedList in java
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // code to insert element at first
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    // code to insert element at last
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // code to insert an element at random index
    public void insertRandom(int val, int idx) {
        if (idx == 0) {
            insertFirst(val);
            return;
        }
        if (idx == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //---------------------------------------------------------------
    // display method to display the linkedlist
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    //---------------------------------------------------------------
    // pointing to a particular node
    public Node get(int idx) {
        Node node = head;
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }
        return node;
    }

    // delete first
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // delete last
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    // delete random
    public int deleteRandom(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    // search operation in linkedList
    public Node search(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(31);
        list.insertFirst(1);
        list.insertFirst(2000);
        list.insertLast(11);
        list.insertLast(3);
        list.insertLast(2001);
        list.insertRandom(143, 3);
        list.display();

        list.deleteFirst();
        list.deleteLast();
        System.out.println(list.deleteRandom(2));
        list.display();
        System.out.println(list.size);
        System.out.println(list.search(11));
    }
}
