package Chap2;

/* Contains methods that serve the purpose of deleting a node in the middle (i.e. any node but the
*  first and last node, not necessarily the exact middle). */
public class Prob3 {

    /* This method takes O(1) time and O(1) space.  We take the node we are given, and replace the
    *  data within it with that of the next node. Then skip over the next node and point our node's
    *  next field to what was the next of next. */
    public static void deleteNode(Node n) {
        Node next = n.next;
        n.data = next.data;
        n.next = n.next.next;
    }

    public static void deleteNodeAndPrint(Node head, Node targetNode) {
        System.out.println("Original Linked List:");
        LinkedListTool.printLinkedList(head);
        deleteNode(targetNode);
        System.out.println("Node removed:");
        LinkedListTool.printLinkedList(head);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node head = LinkedListTool.constructLinkedListOfSize(10);
        Node n = head.next.next.next.next;

        // Expect 5 to be missing
        deleteNodeAndPrint(head, n);
    }
}
