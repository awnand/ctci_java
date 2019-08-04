package Chap5;

/* Contains methods for the purpose of swapping odd and even bits in an Integer with as few instructions
*  as possible (e.g. bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on). */
public class Prob7 {

    public static int swapEvenOddBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        // Expected 624.
        System.out.println(swapEvenOddBits(432));
        // Expected 12.
        System.out.println(swapEvenOddBits(12));
        // Expected 986717.
        System.out.println(swapEvenOddBits(986542));
    }
}
