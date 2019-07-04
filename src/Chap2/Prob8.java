package Chap2;

import java.util.HashSet;

public class Prob8 {

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

    public static Node findBeginning2(Node head) {
        return null;
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

    public static void main(String[] args) {
        Node n1 = LinkedListTool.constructLinkedListOfSize(5);
        Node cursor = n1;
        while (cursor.hasNext()) {
            cursor = cursor.next;
        }
        cursor.next = n1.next.next;

        findBeginningAndPrint(n1);
    }
}
