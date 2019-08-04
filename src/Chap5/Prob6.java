package Chap5;

/* Contains methods for the purpose of, given integer inputs A and B, determining the number of bits
*  needed to flip to convert integer A to integer B.*/
public class Prob6 {

    /* This problem is actually quite simple.  The XOR operation returns 1 when two corresponding bits
    *  within separate Integers are different (i.e. when they would need to swapped).  After we perform
    *  the operation, we simply count the bits within the resulting Integer.  The method takes O(N)
    *  time where N is the number of bits representing the Integer and takes O(1) space. */
    public static int findBitSwapRequired(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    public static void main(String[] args) {
        // Expected 2.
        System.out.println(findBitSwapRequired(29, 15));
        // Expected 2.
        System.out.println(findBitSwapRequired(34, 58));
        // Expected 20.
        System.out.println(findBitSwapRequired(-325453, 128));
        // Expected 3.
        System.out.println(findBitSwapRequired(512, 10));
    }
}
