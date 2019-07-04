package Chap2;

public class Prob5 {

    public static Node addBackward(Node l1, Node l2, int carry) {
        if (l1 == null && l1 == null) {
            return carry == 0 ? null : new Node(carry);
        } else if (l1 == null) {
            l1 = new Node(0);
        } else if (l2 == null) {
            l2 = new Node(0);
        }

        Node digit = new Node((carry + l1.data + l2.data) % 10);
        carry = (carry + l1.data + l2.data) / 10;
        digit.next = addBackward(l1.next, l2.next, carry);
        return digit;
    }


    public static Node addForward(Node l1, Node l2) {
        int numDigits1 = countDigits(l1);
        int numDigits2 = countDigits(l2);
        // If l1 is larger, it will be extended, if not it remains the same, while l2 is extended.
        Node head1 = padZeroes(l2, numDigits1 - numDigits2);
        Node head2 = padZeroes(l1, numDigits2 - numDigits1);
        // Our answer array takes on the length of the longer list plus 1 to account for a carry.
        int[] ans = new int[(numDigits1 > numDigits2 ? numDigits1 : numDigits2) + 1];
        // The most significant digit starts as 0 until it is increased due to a carry.
        ans[0] = 0;
        int currAnsIndex = 1;
        while (head1 != null) {
            int sum = head1.data + head2.data;
            // In this case, we need to carry over to the larger digits.
            if (sum >= 10) {
                ans[currAnsIndex] = sum % 10;
                carry(ans, currAnsIndex, sum / 10);
            } else {
                ans[currAnsIndex] = sum % 10;
            }
            currAnsIndex++;
            head1 = head1.next;
            head2 = head2.next;
        }
        // Populate the return list.
        Node ansHead = new Node(ans[0]);
        for (int i = 1; i < ans.length; i++) {
            ansHead.appendToTail(ans[i]);
        }
        // If we never had to carry into our extra index at the front, we can ignore it.
        if (ansHead.data == 0 && ansHead.hasNext()) {
            ansHead = ansHead.next;
        }
        return ansHead;
    }

    public static Node addForward2(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addBackward(l1, l2, 0));
    }

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

    // Carry backtracks in the answerArr, starting from currAnsIndex, adding and carrying values.
    private static void carry(int[] answerArr, int currAnsIndex, int carryValue) {
        for (int i = currAnsIndex - 1; i >= 0; i--) {
            int oldAns = answerArr[i];
            answerArr[i] = (oldAns + carryValue) % 10;
            carryValue = (oldAns + carryValue) / 10;
        }
    }

    /* Returns the amount of items in the linked list, and thus the number of digits being
    *  represented. */
    private static int countDigits(Node head) {
        if (head == null) {
            return 0;
        }
        int numDigits = 1;
        while (head.hasNext()) {
            head = head.next;
            numDigits++;
        }
        return numDigits;
    }

    /* Returns a list with the amount of zeroes specified in the second argument to the front
    /* of the node. */
    private static Node padZeroes(Node head, int amountOfZeroes) {
        while (amountOfZeroes > 0) {
            Node zeroNode = new Node(0);
            zeroNode.next = head;
            head = zeroNode;
            amountOfZeroes--;
        }
        return head;
    }

    public static void addBackwardAndPrint(Node l1, Node l2) {
        System.out.println("Original Linked List 1:");
        LinkedListTool.printLinkedList(l1);
        System.out.println("Original Linked List 2:");
        LinkedListTool.printLinkedList(l2);
        System.out.println("Resulting added List:");
        LinkedListTool.printLinkedList(addBackward(l1, l2, 0));
        System.out.println("-----------------------");
    }

    public static void addForwardAndPrint(Node l1, Node l2) {
        System.out.println("Original Linked List 1:");
        LinkedListTool.printLinkedList(l1);
        System.out.println("Original Linked List 2:");
        LinkedListTool.printLinkedList(l2);
        System.out.println("Resulting added List:");
        LinkedListTool.printLinkedList(addForward(l1, l2));
        System.out.println("-----------------------");
    }

    public static void addForward2AndPrint(Node l1, Node l2) {
        System.out.println("Original Linked List 1:");
        LinkedListTool.printLinkedList(l1);
        System.out.println("Original Linked List 2:");
        LinkedListTool.printLinkedList(l2);
        System.out.println("Resulting added List:");
        LinkedListTool.printLinkedList(addForward2(l1, l2));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        // Simple example with even amount of digits.
        Node n1_1 = new Node(7);
        n1_1.appendToTail(1);
        n1_1.appendToTail(6);
        Node n2_1 = new Node(5);
        n2_1.appendToTail(9);
        n2_1.appendToTail(2);
        // Expected 2, 1, 9
        addBackwardAndPrint(n1_1, n2_1);

        // Example where one number has more digits than the other and requires more carries.
        Node n1_2 = new Node(7);
        n1_2.appendToTail(1);
        n1_2.appendToTail(6);
        n1_2.appendToTail(1);
        n1_2.appendToTail(2);
        n1_2.appendToTail(3);
        Node n2_2 = new Node(5);
        n2_2.appendToTail(9);
        n2_2.appendToTail(5);
        // Expected 2, 1, 2, 2, 2, 3
        addBackwardAndPrint(n1_2, n2_2);
        //Expected 1, 3, 0, 8
        addForwardAndPrint(n1_1, n2_1);
        //Expected 1, 3, 0, 8
        addForward2AndPrint(n1_1, n2_1);
    }
}
