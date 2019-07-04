package Chap2;

public class Prob2 {

    public static int findKthtoLast(Node head, int k) {
        Node slow = head;
        Node fast = head;
        int i = 1;
        while (i < k) {
            if (fast.hasNext()) {
                fast = fast.next;
            } else {
                throw new IllegalArgumentException("k is too large for the size of the list.");
            }
            i++;
        }

        while (fast.hasNext()) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        Node n = LinkedListTool.constructLinkedListOfSize(10);

        // Expect 10
        System.out.println(findKthtoLast(n, 1));
        // Expect 9
        System.out.println(findKthtoLast(n, 2));
        // Expect 2
        System.out.println(findKthtoLast(n, 9));
        // Expect 1
        System.out.println(findKthtoLast(n, 10));
    }

}
