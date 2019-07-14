package Chap2;

/* Contains methods which serve the purpose of determining if two Linked Lists intersect and returning
 * the Node where they do.*/
public class Prob7 {

    /* This method takes O(1) space and O(N) time.  We can find if two Linked Lists have an inter-
    *  section by first counting the number of items they both have, moving a pointer on the longer
    *  one of the two x many times (where x = difference between lengths of Linked Lists), and then
    *  moving two separate pointers on the Linked Lists respectively a single Node forward iteratively
    *  until you find matching Nodes. */
    public static Node findIntersection(Node l1, Node l2) {
        // Count the items in both Linked Lists.
        int l1Size = countItems(l1);
        int l2Size = countItems(l2);
        // Calculate the difference in size and then move forward diff many times on the larger list.
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
        // Move forward on both Linked Lists until you find Nodes that are equivalent.
        while (large != null) {
            if (large == small) {
                return large;
            }
            large = large.next;
            small = small.next;
        }
        return null;
    }

    // Count the number of elements within a Linked List.
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
