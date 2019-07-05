package Chap2;

// A tool class with helper methods for working with Linked Lists throughout this chapter.
public class LinkedListTool {

    // Prints the elements a Linked List.
    public static void printLinkedList(Node head) {
       Node n = head;
       while (n != null) {
           if (n.next == null) {
               System.out.println(n.data);
           } else {
               System.out.print(n.data + " --> ");
           }
           n = n.next;
       }
    }

    // Constructs a Linked List containing elements starting from 1 through k (inclusive).
    public static Node constructLinkedListOfSize(int k) {
        Node head = new Node(1);

        for (int i = 2; i <= k; i++) {
            head.appendToTail(i);
        }

        return head;
    }
}