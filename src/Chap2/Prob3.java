package Chap2;

public class Prob3 {

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
