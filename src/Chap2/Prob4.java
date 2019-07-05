package Chap2;

/* Contains methods which serve the purpose of partitioning a Linked List around a value x, such
*  that all nodes less than x come before all nodes greater than or equal to x. */
public class Prob4 {

    /* This method takes O(N) space and O(N) time. We essentially build two new Linked Lists. Left
    *  represents everything less than x, while right represents everything larger or equal too.
    *  After we're done building the two lists, we just connect them together and we have a
    *  partitioned Linked List. */
    public static Node partition(Node head, int x) {
        Node left = null;
        Node right = null;

        // We go through our Linked List in a single pass.
        Node cursor = head;
        while (cursor != null) {
            /* Depending on the value of the current Node's data, add that same data to either left
            *  or right. */
            int currData = cursor.data;
            if (currData < x) {
                if (left == null) {
                    left = new Node(currData);
                } else {
                    left.appendToTail(currData);
                }
            } else {
                if (right == null) {
                    right = new Node(currData);
                } else {
                    right.appendToTail(currData);
                }
            }
            cursor = cursor.next;
        }
        // If x was the smallest value, then we already have our partitioned list with right.
        if (left == null) {
            return right;
        }
        // Join together left and right.
        Node n = left;
        while (n.hasNext()) {
            n = n.next;
        }
        n.next = right;
        return left;
    }

    public static Node constructSimpleList() {
        Node n = new Node(3);
        n.appendToTail(5);
        n.appendToTail(8);
        n.appendToTail(5);
        n.appendToTail(10);
        n.appendToTail(2);
        n.appendToTail(1);
        return n;
    }

    public static void partitionAndPrint(Node n, int x) {
        System.out.println("Original Linked List:");
        LinkedListTool.printLinkedList(n);
        System.out.println("Partitioned List:");
        LinkedListTool.printLinkedList(partition(n, x));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node n = constructSimpleList();
        // Expect 3, 2, 1, 5, 8, 5, 10
       partitionAndPrint(n, 5);
    }
}
