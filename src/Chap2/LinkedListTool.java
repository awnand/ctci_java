package Chap2;

public class LinkedListTool {
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

    public static Node constructLinkedListOfSize(int k) {
        Node head = new Node(1);

        for (int i = 2; i <= k; i++) {
            head.appendToTail(i);
        }

        return head;
    }
}