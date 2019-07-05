package Chap2;

// Contains methods that serve the purpose of finding the K-th to last element in a Linked List.
public class Prob2 {

    /* This method takes O(1) space and O(N) time. We start by taking the Node pointer fast and
    *  moving it k elements up if possible.  Now slow and fast are exactly k-steps apart.  Then
    *  we progress slow and fast together until fast reaches the end of the Linked List.  At this
    *  point, slow will point to the k-th to last element. */
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
