package Chap2;

import java.util.HashSet;

/* Contains static methods that serve the purpose of removing duplicated integers
*  from a Linked List. */
public class Prob1 {

    /* This method takes O(1) space and O(N^2) time. For every node, we check the rest of the Linked
    *  List for matching data values and remove them. */
    public static Node removeDups(Node head) {
        Node n = head;
        while (n != null) {
            n.next = Node.deleteNode(n.next, n.data);
            n = n.next;
        }
        return head;
    }

    /* This method takes O(N) space due to the seenData set and O(N) time because we only need to
    *  complete a single pass. Simply pass through the Linked List and whenever you run into data
    *  that you have seen before, remove the Node from the Linked List. */
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
