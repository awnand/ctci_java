package Chap2;

/* A class representing the elements of a Linked List.  In this class, we represent data with
*  integers but this we could easily generalize. */
public class Node {

    public int data;
    public Node next = null;

    public Node(int d) {
        data = d;
    }

    // Appends a new Node containing the given integer to the end of the Linked List.
    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public boolean hasNext() {
        return next != null;
    }

    // Deletes the first instance of a Node containing the given integer from the Linked List.
    public static Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
