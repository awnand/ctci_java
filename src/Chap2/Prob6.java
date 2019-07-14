package Chap2;

// Contains methods which serve the purpose of checking if a Linked List is a palindrome.
public class Prob6 {

    /* This method takes O(1) space and O(N) time.  First we call countItems, which takes O(N) time
    *  to count the number of elements within the Linked List.  Then it calls xorAll on the Linked
    *  List and checks that the resulting value is the correct one for the parity of the number of
    *  elements within the Linked List.  xorAll also takes O(N) time. */
    public static boolean isPalindrome(Node head) {
        int numItems = countItems(head);
        if (numItems % 2 == 0) {
            int xorValue = xorAll(head);
            if (xorValue == 0) {
                return true;
            }
        } else {
            int middleData = getMiddleItem(head, numItems);
            int xorValue = xorAll(head);
            if (xorValue == middleData) {
                return true;
            }
        }

        return false;
    }

    // Performs an XOR operation on all of the elements of a Linked List.
    private static int xorAll(Node head) {
        int xor = head.data;
        head = head.next;
        while (head != null) {
            xor ^= head.data;
            head = head.next;
        }
        return xor;
    }

    // Returns the data of the middle element of the Linked List.
    private static int getMiddleItem(Node head, int numItems) {
        int i = 1;
        while (i != (numItems/2) + 1) {
            head = head.next;
            i++;
        }
        return head.data;
    }

    // Counts the number of elements within a Linked List.
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

    // Returns a new Linked List that is the reverse of the input Linked List.
    private static Node reverse(Node n) {
        Node reversed = null;
        while (n != null) {
            Node currNode = new Node(n.data);
            currNode.next = reversed;
            reversed = currNode;
            n = n.next;
        }
        return reversed;
    }

    public static void checkPalindromeAndPrint(Node n) {
        System.out.println("Linked List:");
        LinkedListTool.printLinkedList(n);
        System.out.println("Is Palindrome:");
        System.out.println(isPalindrome(n));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Node n1 = LinkedListTool.constructLinkedListOfSize(5);
        Node head = n1;
        while (head.hasNext()) {
            head = head.next;
        }
        head.next = reverse(n1);

        Node n2 = LinkedListTool.constructLinkedListOfSize(5);
        Node n2_reverse = reverse(n2);
        n2.appendToTail(6);
        Node head2 = n2;
        while (head2.hasNext()) {
            head2 = head2.next;
        }
        head2.next = n2_reverse;

        // Expected true.
        checkPalindromeAndPrint(n1);
        // Expected true.
        checkPalindromeAndPrint(n2);
        // Expected false.
        checkPalindromeAndPrint(n2_reverse);
    }
}
