package Chap2;

public class Prob4 {

    public static Node partition(Node head, int x) {
        Node left = null;
        Node right = null;

        Node cursor = head;
        while (cursor != null) {
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

        if (left == null) {
            return right;
        }

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
