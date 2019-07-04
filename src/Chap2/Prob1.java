package Chap2;

import java.util.HashSet;

public class Prob1 {

    //
    public static Node removeDups(Node head) {
        Node n = head;
        while (n != null) {
            n.next = Node.deleteNode(n.next, n.data);
            n = n.next;
        }
        return head;
    }

    public static Node removeDups2(Node head) {
        HashSet<Integer> seenData = new HashSet<>();
        Node n = head;
        seenData.add(n.data);
        while (n.next != null) {
            if (seenData.contains(n.next.data)) {
                n.next = Node.deleteNode(n.next, n.next.data);
            } else {
                seenData.add(n.next.data);
                n = n.next;
            }
        }
        return head;
    }

    public static void removeDupsAndPrint(Node head) {
        System.out.println("Original Linked List:");
        LinkedListTool.printLinkedList(head);
        removeDups(head);
        System.out.println("Duplicates Removed:");
        LinkedListTool.printLinkedList(head);
        System.out.println("-----------------------");
    }

    public static void removeDups2AndPrint(Node head) {
        System.out.println("Original Linked List:");
        LinkedListTool.printLinkedList(head);
        removeDups2(head);
        System.out.println("After Duplicates Removed:");
        LinkedListTool.printLinkedList(head);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node n1 = LinkedListTool.constructLinkedListOfSize(3);
        Node n2 = LinkedListTool.constructLinkedListOfSize(3);

        for (int i = 2; i < 4; i++) {
            n1.appendToTail(i);
            n2.appendToTail(i);
        }

        // For both cases below we expect 1, 2, 3, 1, 2, 3
        removeDupsAndPrint(n1);
        removeDups2AndPrint(n2);
    }
}
