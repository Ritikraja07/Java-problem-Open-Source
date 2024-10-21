class DoublyLinkedList {
    // Node class for doubly linked list
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail pointers of the list
    Node head, tail = null;

    // Method to add a node at the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);

        // If the list is empty
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to display nodes from the beginning
    public void displayForward() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        System.out.print("Doubly Linked List (forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display nodes from the end (backward)
    public void displayBackward() {
        if (tail == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = tail;
        System.out.print("Doubly Linked List (backward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Method to delete a node from the list
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        // Node to delete is not found
        if (current == null) {
            System.out.println("Node with data " + data + " not found.");
            return;
        }

        // If the node to delete is the head node
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } 
        // If the node to delete is the tail node
        else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } 
        // If the node is in the middle
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Node with data " + data + " deleted.");
    }

    // Main method to demonstrate the doubly linked list
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Adding nodes to the list
        dll.addNode(10);
        dll.addNode(20);
        dll.addNode(30);
        dll.addNode(40);
        dll.addNode(50);

        // Displaying the list forward and backward
        dll.displayForward();   
        dll.displayBackward();  

        // Deleting a node
        dll.deleteNode(30);

        // Displaying the list again
        dll.displayForward();   
        dll.displayBackward();  
    }
}
