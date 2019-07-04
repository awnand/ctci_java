package Chap2;

public class Prob7 {

    public static Node findIntersection(Node l1, Node l2) {
        int l1Size = countItems(l1);
        int l2Size = countItems(l2);

        Node large;
        Node small;
        int diff;
        if (l1Size > l2Size) {
            large = l1;
            small = l2;
            diff = l1Size - l2Size;
        } else {
            large = l2;
            small = l1;
            diff = l2Size - l1Size;
        }

        while (diff > 0) {
            large = large.next;
        }

        while (large != null) {
            if (large == small) {
                return large;
            }
            large = large.next;
            small = small.next;
        }
        return null;
    }

    private static int countItems(Node head) {
        if (head == null) {
            return 0;
        }
        int numItems = 1;
        while (head.hasNext()) {
            head = head.next;
            numItems++;
        }
        return numItems;
    }

    public static void findIntersectionAndPrint(Node l1, Node l2) {
        System.out.println("First Linked List:");
        LinkedListTool.printLinkedList(l1);
        System.out.println("Second Linked List:");
        LinkedListTool.printLinkedList(l2);
        System.out.println("Intersection:");
        LinkedListTool.printLinkedList(findIntersection(l1, l2));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node n1 = LinkedListTool.constructLinkedListOfSize(5);
        Node n2 = LinkedListTool.constructLinkedListOfSize(2);
        n2.next.next = n1.next.next;

        // Expected 3, 4, 5
        findIntersectionAndPrint(n1, n2);
    }
}
