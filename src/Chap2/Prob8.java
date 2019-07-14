package Chap2;

import java.util.HashSet;

/* Contains methods which serve the purpose of detecting loops in a circular Linked List. A circular
*  Linked List is a corrupt Linked List in which a Node's next pointer points to an earlier node, as
*  to make a loop in the Linked List. */
public class Prob8 {

    /* This method takes O(N) space and O(N) time, where N is the size of the Linked List.  Simply
    *  build a Set of Nodes that have been seen and traverse the Linked List until you run into one
    *  that has seen before. */
    public static Node findBeginning(Node head) {
        HashSet<Node> seenNodes = new HashSet<>();
        while (head != null) {
            if (seenNodes.contains(head)) {
                return head;
            }
            seenNodes.add(head);
            head = head.next;
        }
        return null;
    }

    /* This method takes O(1) space and O(N) time, where N is the size of the Linked List. */
    public static Node findBeginning2(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                break;
            }
        }

        if (fastPointer == null || fastPointer.next == null) {
            return null;
        }

        slowPointer = head;
        while (slowPointer != fastPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return fastPointer;
    }

    public static void printLoop(Node head) {
        Node n = head;
        HashSet<Node> seenNodes = new HashSet<>();
        while (!seenNodes.contains(n)) {
            System.out.print(n.data + " --> ");
            seenNodes.add(n);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void findBeginningAndPrint(Node head) {
        System.out.println("Full Corrupted List:");
        printLoop(head);
        System.out.println("Beginning of Loop:");
        printLoop(findBeginning(head));
        System.out.println("-----------------------");
    }

    public static void findBeginning2AndPrint(Node head) {
        System.out.println("Full Corrupted List:");
        printLoop(head);
        System.out.println("Beginning of Loop:");
        printLoop(findBeginning2(head));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node n1 = LinkedListTool.constructLinkedListOfSize(5);
        Node cursor = n1;
        while (cursor.hasNext()) {
            cursor = cursor.next;
        }
        cursor.next = n1.next.next;

        // Expected 3, 4, 5, 3
        findBeginningAndPrint(n1);
        // Expected 3, 4, 5, 3
        findBeginning2AndPrint(n1);
    }
}
